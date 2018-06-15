package com.mmdworks.recap.dto;
import java.util.Date;
import java.util.List;

public class PropertyDto {

	private long propertyId;

	private String name;

	private String address;

	private String city;

	private String state;

	private String country;

	private Date purchaseDate;

	private long purchaseAmount;

	private long currentValue;

	private long closingCost;

	private long sellingCost;

	private String notes;
	
	private long userId;

	private List<DocumentDto> propertyDocuments;
	
	private List<MortageDetailsDto> mortageDetails;

	public long getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(long propertyId) {
		this.propertyId = propertyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public long getPurchaseAmount() {
		return purchaseAmount;
	}

	public void setPurchaseAmount(long purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
	}

	public long getCurrentValue() {
		return currentValue;
	}

	public void setCurrentValue(long currentValue) {
		this.currentValue = currentValue;
	}

	public long getClosingCost() {
		return closingCost;
	}

	public void setClosingCost(long closingCost) {
		this.closingCost = closingCost;
	}

	public long getSellingCost() {
		return sellingCost;
	}

	public void setSellingCost(long sellingCost) {
		this.sellingCost = sellingCost;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public List<DocumentDto> getPropertyDocuments() {
		return propertyDocuments;
	}

	public void setPropertyDocuments(List<DocumentDto> propertyDocuments) {
		this.propertyDocuments = propertyDocuments;
	}

	public List<MortageDetailsDto> getMortageDetails() {
		return mortageDetails;
	}

	public void setMortageDetails(List<MortageDetailsDto> mortageDetails) {
		this.mortageDetails = mortageDetails;
	}

	
	
}
