package com.mmdworks.recap.jsonhelper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mmdworks.recap.domain.MortageDetails;
import com.mmdworks.recap.domain.Property;
import com.mmdworks.recap.domain.PropertyDocument;
import com.mmdworks.recap.domain.User;
import com.mmdworks.recap.domain.UserDocument;

public class UserDocumentJsonHelper {
	
	public static User getUserDocumentJson() {
		List<UserDocument> userDocList = new ArrayList<>();
		return null;
		
	}
	
	public static Property getPropertyJson() {
		List<PropertyDocument> docList = new ArrayList<>();
		PropertyDocument document = new PropertyDocument();
		document.setDescription("document proof related to my property");
		document.setDocName("Landa document");
		document.setSavedPath("c://recap-documents");
		document.setType("Rental Document");
		docList.add(document);
		
		MortageDetails mortageDetails = new MortageDetails();
		mortageDetails.setDownPayment(20);
		mortageDetails.setLoanOriginationFees(50);
		mortageDetails.setMortageAmount(100);
		mortageDetails.setNoOfYears(4);
		mortageDetails.setPointPaid(5);
		List<MortageDetails> mortageList = new ArrayList<>();
		mortageList.add(mortageDetails);
		
		Property property = new Property();
		property.setAddress("98 Winn St, Woburn, MA 01801, USA");
		property.setCity("Los Angeles");
		property.setState("California");
		property.setCountry("USA");
		property.setName("Prestage Heights");
		property.setPurchaseDate(new Date());
		property.setPurchaseAmount(100000);
		property.setCurrentValue(250000);
		property.setClosingCost(200000);
		property.setSellingCost(250000);
		property.setPropertyDocuments(docList);
		property.setMortageDetails(mortageList);
		
		return property;
	}
	
	

}
