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
@Table(name = "device_details")
public class Device {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "device_id")
	private long deviceId;
	
	@Column(name="device_os")
	private String deviceOS;
	
	@Column(name="device_reg_id")
	private String deviceRegId;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	@JsonIgnore
	private User user;

	//getters and setters
	public long getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(long deviceId) {
		this.deviceId = deviceId;
	}

	public String getDeviceOS() {
		return deviceOS;
	}

	public void setDeviceOS(String deviceOS) {
		this.deviceOS = deviceOS;
	}

	public String getDeviceRegId() {
		return deviceRegId;
	}

	public void setDeviceRegId(String deviceRegId) {
		this.deviceRegId = deviceRegId;
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
		builder.append("Device [deviceId=");
		builder.append(deviceId);
		builder.append(", deviceOS=");
		builder.append(deviceOS);
		builder.append(", deviceRegId=");
		builder.append(deviceRegId);
		builder.append(", user=");
		builder.append(user);
		builder.append("]");
		return builder.toString();
	}
	
	

	
}
