package com.mmdworks.recap.dto;

import java.util.Date;

import com.mmdworks.recap.enums.TransactionType;

public class CashFlowInputDto {

	private long userId;
	private long propertyId;
	private Date startDate;
	private Date endDate;
	private TransactionType transactionType;
	
	//setters and getters
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public TransactionType getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}
	public long getPropertyId() {
		return propertyId;
	}
	public void setPropertyId(long propertyId) {
		this.propertyId = propertyId;
	}
	
	

	
}
