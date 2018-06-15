package com.mmdworks.recap.endpoint;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.mmdworks.recap.dto.FileUploadMessage;
import com.mmdworks.recap.service.S3Wrapper;
import com.mmdworks.recap.utils.FileHelper;

@RestController
@RequestMapping("/file-mgmt-svc")
public class FileMgmtEndPoint {

	@Autowired
	private S3Wrapper s3wrapper;

	@GetMapping("/get-list-buckets")
	public List<Bucket> getBuckets() {
		return s3wrapper.listBuckets();
	}

	@GetMapping("/test-s3-file-upload")
	public PutObjectResult testFileUpload() {
		File file = new File("D:\\Images\\deepu_google-pic.jpg");
		System.out.println(file.length());
		PutObjectResult result = s3wrapper.uploadFile("test-file-1", file);
		return result;
	}

	@PostMapping(value = "/upload-file/{userId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public FileUploadMessage uploadFileToS3Bucket(@PathVariable long userId, @RequestBody MultipartFile file)
			throws IOException {
		System.out.println("File Details::" + file.getSize() + "::" + file.getName());
		FileUploadMessage message = new FileUploadMessage();
		if (file != null && userId != 0) {
			Date dNow = new Date();
			SimpleDateFormat ft = new SimpleDateFormat("yyMMddhhmmssMs");
			String datetime = ft.format(dNow);
			System.out.println("userId" + "-" + "-" + datetime.toString());
			File convertedFile = FileHelper.convert(file);
			String keyvalue = datetime.toString();
			String userIdString = String.valueOf(userId);
			PutObjectResult result = s3wrapper.uploadFile(userIdString + "-" + keyvalue, convertedFile);
			if (result != null) {
				message.setFileUploadedKey(userIdString + "-" + keyvalue);
				message.setFileUploadMsg("File Uploaded succesfuly");
				return message;
			} else {
				message.setFileUploadedKey(null);
				message.setFileUploadMsg("Unable to upload the file to S3 server");
				return message;
			}
		} else {
			message.setFileUploadedKey(null);
			message.setFileUploadMsg("Please upload the file");
			return message;
		}

	}

	@GetMapping("/test-s3-file-download/{fileKey}")
	public ResponseEntity<byte[]> testFileDownload(@PathVariable String fileKey) throws IOException {
		S3Object s3Object = s3wrapper.getFile(fileKey);
		
		S3ObjectInputStream objectInputStream = s3Object.getObjectContent();

		byte[] bytes = IOUtils.toByteArray(objectInputStream);

//		 String fileName = URLEncoder.encode(fileKey, "UTF-8").replaceAll("\\+",
//		 "%20");

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		httpHeaders.setContentLength(bytes.length);
		httpHeaders.setContentDispositionFormData("attachment", fileKey);

		return new ResponseEntity<>(bytes, httpHeaders, HttpStatus.OK);

	}

}
