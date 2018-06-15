package com.mmdworks.recap.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper  {
	
	
	public static Date convertStringToDate(String dateToConvert) throws ParseException{
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date convertedDate=df.parse(dateToConvert);
		return convertedDate;
	}
	

}
