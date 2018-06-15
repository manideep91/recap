package com.mmdworks.recap.service;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;

@Service
public class S3Wrapper {

	@Autowired
	private AmazonS3 amazonS3;

	@Value("${cloud.aws.s3.bucket}")
	private String bucket;

	// list all buckets
	public List<Bucket> listBuckets() {
		return amazonS3.listBuckets();
	}

	// upload file to s3 bucket
	public PutObjectResult uploadFile(String fileKey, File file) {
		System.out.println("Bucket Name:" + bucket);
		PutObjectResult result = amazonS3.putObject(bucket, fileKey, file);
		return result;
	}

	// download file from s3
	public S3Object getFile(String fileKey) {
		GetObjectRequest getObjectRequest = new GetObjectRequest(bucket, fileKey);
		S3Object s3Object = amazonS3.getObject(getObjectRequest);
		return s3Object;
	}

}