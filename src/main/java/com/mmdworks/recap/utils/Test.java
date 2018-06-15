package com.mmdworks.recap.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

	public static void main(String[] args) {
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyMMddhhmmssMs");
		String datetime = ft.format(dNow);
		System.out.println("userId"+"-"+"-"+datetime.toString());
	}
}
