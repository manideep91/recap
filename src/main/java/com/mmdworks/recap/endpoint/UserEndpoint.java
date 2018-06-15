package com.mmdworks.recap.endpoint;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.mmdworks.recap.domain.Property;
import com.mmdworks.recap.domain.User;
import com.mmdworks.recap.dto.InputEmailDto;
import com.mmdworks.recap.dto.LoginInputDto;
import com.mmdworks.recap.service.S3Wrapper;
import com.mmdworks.recap.service.UserService;

@RestController
@RequestMapping("/user-services")
public class UserEndpoint {
	
	private static final Logger logger = Logger.getLogger(Property.class);

	@Autowired
	private UserService userService;

	@Autowired
	private S3Wrapper s3wrapper;

	@GetMapping("/test")
	public String test() {
		return "Working";
	}

	@PostMapping("/create-user")
	public @ResponseBody User createUser(@RequestBody User user) {
		return userService.createuser(user);
	}

	@GetMapping("/get-all-users")
	public List<User> getAllUsers() {
		logger.info("Getting all user list");
		return userService.getAllUsers();
	}

	@GetMapping("/get-user-by-id/{userId}")
	public User getUserById(@PathVariable long userId) {
		return userService.getUserById(userId);
	}

	@PostMapping("/get-user-by-email")
	public ResponseEntity<?> getUserByEmail(@RequestBody InputEmailDto email_Input) {
		return new ResponseEntity<List<User>>(userService.getUserByEmail(email_Input.getEmail()), HttpStatus.OK);
	}

	@PostMapping("/user-login")
	public ResponseEntity<?> checkUserLogin(@RequestBody LoginInputDto loginInputDto) {
		User user = userService.checkUserLoginDetails(loginInputDto.getEmail(), loginInputDto.getPassword());
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@GetMapping("/get-list-buckets")
	public List<Bucket> getBuckets() {
		return s3wrapper.listBuckets();
	}

	@GetMapping("/test-s3-file-upload")
	public PutObjectResult testFileUpload() {
		File file = new File("D:\\Images\\deepu_google-pic.jpg");
		System.out.println(file.length());
		return s3wrapper.uploadFile("test-file-1", file);
	}

	@GetMapping("/test-s3-file-download")
	public ResponseEntity<byte[]> testFileDownload(String fileKey) throws IOException {
		S3Object s3Object = s3wrapper.getFile("test-file-1");
		S3ObjectInputStream objectInputStream = s3Object.getObjectContent();

		byte[] bytes = IOUtils.toByteArray(objectInputStream);

		// String fileName = URLEncoder.encode(key, "UTF-8").replaceAll("\\+", "%20");

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		httpHeaders.setContentLength(bytes.length);
		httpHeaders.setContentDispositionFormData("attachment", "testFile.png");

		return new ResponseEntity<>(bytes, httpHeaders, HttpStatus.OK);

	}

}
