package com.mmdworks.recap.dto;

import java.util.Date;

import com.mmdworks.recap.enums.TransactionType;

public class TransactionDto {

	private long transactionId;

	private TransactionType transactionType;

	private Date date;

	private String purpose;

	private long amount;

	private long propertyId;

	public long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public long getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(long propertyId) {
		this.propertyId = propertyId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TransactionDto [transactionId=");
		builder.append(transactionId);
		builder.append(", transactionType=");
		builder.append(transactionType);
		builder.append(", date=");
		builder.append(date);
		builder.append(", purpose=");
		builder.append(purpose);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", propertyId=");
		builder.append(propertyId);
		builder.append("]");
		return builder.toString();
	}
	
	
}
