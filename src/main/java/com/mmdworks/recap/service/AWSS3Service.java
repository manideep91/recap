package com.mmdworks.recap.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;

@Service
public class AWSS3Service {

	private static final AWSCredentials credentials;
	private static String bucketName;

	private final AmazonS3 s3client;

	public AWSS3Service(AmazonS3 s3client) {
		this.s3client = s3client;
	}
	
	//list all buckets
    public List<Bucket> listBuckets() { 
        return s3client.listBuckets(); 
    }

	static {
		// put your accesskey and secretkey here
		credentials = new BasicAWSCredentials("AKIAJBGUH5NVGAPM2WPA", "zoU/Af9TzGbwIqxJEquadNHb/zPIK3w/cK3o7KUu");
	}
	

	public static void main(String[] args) {
		// set-up the client
		AmazonS3 s3client = AmazonS3ClientBuilder.standard()
				.withCredentials(new AWSStaticCredentialsProvider(credentials)).withRegion(Regions.US_WEST_1).build();

		AWSS3Service awsService = new AWSS3Service(s3client);

		bucketName = "recap-docs";
		
		
		 System.out.println(awsService.listBuckets());
		
	}
}
