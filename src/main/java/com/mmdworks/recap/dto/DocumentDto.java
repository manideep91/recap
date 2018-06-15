package com.mmdworks.recap.dto;

public class DocumentDto {

	private long id;

	private String docName;

	private String description;

	private String type;

	private String savedPath;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSavedPath() {
		return savedPath;
	}

	public void setSavedPath(String savedPath) {
		this.savedPath = savedPath;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DocumentDto [id=");
		builder.append(id);
		builder.append(", docName=");
		builder.append(docName);
		builder.append(", description=");
		builder.append(description);
		builder.append(", type=");
		builder.append(type);
		builder.append(", savedPath=");
		builder.append(savedPath);
		builder.append("]");
		return builder.toString();
	}
	
	
}
