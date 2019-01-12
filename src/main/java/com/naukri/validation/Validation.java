package com.naukri.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

	public boolean nullCheck(String text) {
		System.out.println("Entered into nullCheck :: Validation");
		if (text == null) {

			return true;
		}
		System.out.println("Exited from nullCheck :: Validation");
		return false;
	}

	public boolean isValid(String s) {
		Pattern p = Pattern.compile("(0/91)?[6-9][0-9]{9}");
		Matcher m = p.matcher(s);
		return (m.find() && m.group().equals(s));

	}

}
