package com.mmdworks.recap.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user_documents")
public class UserDocument {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="doc_id")
	private long id;
	
	@Column(name="doc_name")
	private String docName;
	
	@Column(name="description")
	private String description;
	
	@Column(name="type")
	private String type;
	
	@Column(name="saved_path")
	private String savedPath;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	@JsonIgnore
	private User user;
	
	

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserDocument [id=");
		builder.append(id);
		builder.append(", docName=");
		builder.append(docName);
		builder.append(", description=");
		builder.append(description);
		builder.append(", type=");
		builder.append(type);
		builder.append(", savedPath=");
		builder.append(savedPath);
		builder.append(", user=");
		builder.append(user);
		builder.append("]");
		return builder.toString();
	}

	

	

}
