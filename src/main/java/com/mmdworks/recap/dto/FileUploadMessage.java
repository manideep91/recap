package com.mmdworks.recap.dto;

public class FileUploadMessage {

	private String fileUploadMsg;
	private String fileUploadedKey;

	public String getFileUploadMsg() {
		return fileUploadMsg;
	}

	public void setFileUploadMsg(String fileUploadMsg) {
		this.fileUploadMsg = fileUploadMsg;
	}

	public String getFileUploadedKey() {
		return fileUploadedKey;
	}

	public void setFileUploadedKey(String fileUploadedKey) {
		this.fileUploadedKey = fileUploadedKey;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FileUploadMessage [fileUploadMsg=");
		builder.append(fileUploadMsg);
		builder.append(", fileUploadedKey=");
		builder.append(fileUploadedKey);
		builder.append("]");
		return builder.toString();
	}
	
	
}
