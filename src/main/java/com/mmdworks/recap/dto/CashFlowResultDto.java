package com.mmdworks.recap.dto;

public class CashFlowResultDto {

	private long userId;
	private long propertyId;
	private long balance;
	private long expanse;
	private long income;
	private String expenseMonth;
	private String propertyName;
	private long expenseYear;
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getPropertyId() {
		return propertyId;
	}
	public void setPropertyId(long propertyId) {
		this.propertyId = propertyId;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	public long getExpanse() {
		return expanse;
	}
	public void setExpanse(long expanse) {
		this.expanse = expanse;
	}
	public long getIncome() {
		return income;
	}
	public void setIncome(long income) {
		this.income = income;
	}
	public String getExpenseMonth() {
		return expenseMonth;
	}
	public void setExpenseMonth(String expenseMonth) {
		this.expenseMonth = expenseMonth;
	}
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public long getExpenseYear() {
		return expenseYear;
	}
	public void setExpenseYear(long expenseYear) {
		this.expenseYear = expenseYear;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CashFlowResultDto [userId=");
		builder.append(userId);
		builder.append(", propertyId=");
		builder.append(propertyId);
		builder.append(", balance=");
		builder.append(balance);
		builder.append(", expanse=");
		builder.append(expanse);
		builder.append(", income=");
		builder.append(income);
		builder.append(", expenseMonth=");
		builder.append(expenseMonth);
		builder.append(", propertyName=");
		builder.append(propertyName);
		builder.append(", expenseYear=");
		builder.append(expenseYear);
		builder.append("]");
		return builder.toString();
	}
		
	
	
}
