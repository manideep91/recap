package com.mmdworks.recap.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;


@JsonAutoDetect
@Entity
@Table(name = "property")
public class Property {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "property_id")
	private long propertyId;

	@Column(name = "property_name")
	private String name;

	@Column(name = "property_address")
	private String address;

	@Column(name = "city")
	private String city;

	@Column(name = "state")
	private String state;

	@Column(name = "country")
	private String country;

	@Column(name = "purchase_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date purchaseDate;

	@Column(name = "purchase_amount")
	private long purchaseAmount;

	@Column(name = "current_value")
	private long currentValue;

	@Column(name = "closing_cost")
	private long closingCost;

	@Column(name = "selling_cost")
	private long sellingCost;

	@Column(name = "property_notes")
	private String notes;

	@OneToMany(mappedBy = "property",cascade=CascadeType.PERSIST)
	private List<PropertyDocument> propertyDocuments;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	@JsonIgnore
	private User user;
	
	@OneToMany(mappedBy="property",cascade= CascadeType.PERSIST)
	private List<MortageDetails> mortageDetails;

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

	public List<PropertyDocument> getPropertyDocuments() {
		return propertyDocuments;
	}

	public void setPropertyDocuments(List<PropertyDocument> propertyDocuments) {
		this.propertyDocuments = propertyDocuments;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<MortageDetails> getMortageDetails() {
		return mortageDetails;
	}

	public void setMortageDetails(List<MortageDetails> mortageDetails) {
		this.mortageDetails = mortageDetails;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Property [propertyId=");
		builder.append(propertyId);
		builder.append(", name=");
		builder.append(name);
		builder.append(", address=");
		builder.append(address);
		builder.append(", city=");
		builder.append(city);
		builder.append(", state=");
		builder.append(state);
		builder.append(", country=");
		builder.append(country);
		builder.append(", purchaseDate=");
		builder.append(purchaseDate);
		builder.append(", purchaseAmount=");
		builder.append(purchaseAmount);
		builder.append(", currentValue=");
		builder.append(currentValue);
		builder.append(", closingCost=");
		builder.append(closingCost);
		builder.append(", sellingCost=");
		builder.append(sellingCost);
		builder.append(", notes=");
		builder.append(notes);
		builder.append(", propertyDocuments=");
		builder.append(propertyDocuments);
		builder.append(", user=");
		builder.append(user);
		builder.append(", mortageDetails=");
		builder.append(mortageDetails);
		builder.append("]");
		return builder.toString();
	}

	
}
