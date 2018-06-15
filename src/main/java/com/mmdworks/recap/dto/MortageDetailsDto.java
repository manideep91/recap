package com.mmdworks.recap.dto;

public class MortageDetailsDto {

	private long mortageDetailsId;

	private long downPayment;

	private long mortageAmount;

	private long noOfYears;

	private long loanOriginationFees;

	private long pointPaid;

	// getters and setters
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

}
