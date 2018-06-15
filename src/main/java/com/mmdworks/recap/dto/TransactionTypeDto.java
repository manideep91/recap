package com.mmdworks.recap.dto;

import com.mmdworks.recap.enums.TransactionType;

public class TransactionTypeDto {

	private TransactionType transactionType;
	private long properyId;

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public long getProperyId() {
		return properyId;
	}

	public void setProperyId(long properyId) {
		this.properyId = properyId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TransactionTypeDto [transactionType=");
		builder.append(transactionType);
		builder.append(", properyId=");
		builder.append(properyId);
		builder.append("]");
		return builder.toString();
	}

}
