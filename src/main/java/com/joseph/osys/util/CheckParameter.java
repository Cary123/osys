package com.joseph.osys.util;

import com.mysql.cj.core.util.StringUtils;

public class CheckParameter {
	public static boolean checkParameterNullOrEmpty(String argsOne){
		return StringUtils.isNullOrEmpty(argsOne);
	}
	
	public static boolean checkParameterNullOrEmpty(String argsOne, String argsTwo){
		return StringUtils.isNullOrEmpty(argsOne) && StringUtils.isNullOrEmpty(argsTwo);
	}
	
	public static boolean checkParameterNullOrEmpty(String argsOne, String argsTwo, String argsThree){
		return StringUtils.isNullOrEmpty(argsOne) && StringUtils.isNullOrEmpty(argsTwo) && StringUtils.isNullOrEmpty(argsThree);
	}
	
	public static boolean checkParameterNullOrEmpty(Object argsOne){
		return argsOne.equals(null);
	}
	
	public static boolean checkParameterNullOrEmpty(Object argsOne ,Object argsTwo){
		return argsOne.equals(null) && argsTwo.equals(null);
	}
}
