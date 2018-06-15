package com.mmdworks.recap.domain;

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
@Table(name = "mortage_details")
public class MortageDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "mortage_details_id")
	private long mortageDetailsId;

	@Column(name = "down_payment")
	private long downPayment;

	@Column(name = "mortage_amount")
	private long mortageAmount;

	@Column(name = "no_of_years")
	private long noOfYears;

	@Column(name = "fees")
	private long loanOriginationFees;

	@Column(name = "point_paid")
	private long pointPaid;

	@ManyToOne
	@JoinColumn(name = "property_id")
	@JsonIgnore
	private Property property;

	public long getMortageDetailsId() {
		return mortageDetailsId;
	}

	public void setMortageDetailsId(long mortageDetailsId) {
		this.mortageDetailsId = mortageDetailsId;
	}

	public long getDownPayment() {
		return downPayment;
	}

	public void setDownPayment(long downPayment) {
		this.downPayment = downPayment;
	}

	public long getMortageAmount() {
		return mortageAmount;
	}

	public void setMortageAmount(long mortageAmount) {
		this.mortageAmount = mortageAmount;
	}

	public long getNoOfYears() {
		return noOfYears;
	}

	public void setNoOfYears(long noOfYears) {
		this.noOfYears = noOfYears;
	}

	public long getLoanOriginationFees() {
		return loanOriginationFees;
	}

	public void setLoanOriginationFees(long loanOriginationFees) {
		this.loanOriginationFees = loanOriginationFees;
	}

	public long getPointPaid() {
		return pointPaid;
	}

	public void setPointPaid(long pointPaid) {
		this.pointPaid = pointPaid;
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}
	
	
}
