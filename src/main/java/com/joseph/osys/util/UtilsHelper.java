package com.joseph.osys.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtilsHelper {
	public static int getRandNum(int min, int max) {
	    int randNum = min + (int)(Math.random() * ((max - min) + 1));
	    return randNum;
	}
	
	public static boolean isEmail(String email) {
		Pattern emailPattern = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
		Matcher matcher = emailPattern.matcher(email);
		if(matcher.find()){
		return true;
		}
		return false;
	}
	
	public static boolean isUserNameRight(String userName) {
		String reg = "^\\w{2,16}$";
		return userName.matches(reg);
	}
	
}
