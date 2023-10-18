package com.training.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Validation {
	public static boolean phNoVal(String phNo) {
		if(phNo.length() != 10) {
			return false;
		}
		else {
			for(int i=0;i<phNo.length();i++) {
				if(!Character.isDigit(phNo.charAt(i)))
					return false;
			}
		}
		return true;
	}

	public static boolean emailVal(String email) {
		Pattern p = Pattern.compile("^[a-zA-z]{2,}[a-zA-Z0-9_.-]+@[a-z]{3,}[.com|.in]+$");
		Matcher m = p.matcher(email);
		boolean b = m.matches();
		return b;
	}
}