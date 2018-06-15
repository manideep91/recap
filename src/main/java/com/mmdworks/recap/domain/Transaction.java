package com.mmdworks.recap.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mmdworks.recap.enums.TransactionType;


@Entity
@Table(name = "transactions")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "transId")
	private long transactionId;

	@Enumerated(EnumType.STRING)
	@Column(name = "transType")
	private TransactionType transactionType;

	@Column(name = "date")
	private Date date;

	@Column(name = "puproose")
	private String purpose;

	@Column(name = "amount")
	private long amount;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="property_id")
	@JsonIgnore
	private Property property;

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
	
	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Transaction [transactionId=");
		builder.append(transactionId);
		builder.append(", transactionType=");
		builder.append(transactionType);
		builder.append(", date=");
		builder.append(date);
		builder.append(", purpose=");
		builder.append(purpose);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", property=");
		builder.append(property);
		builder.append("]");
		return builder.toString();
	}
	
	

	
	
	
}
