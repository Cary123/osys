package com.joseph.osys.Exception;

import java.util.HashMap;
public class LoginParameterException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	private int code;
	private HashMap<String, String> msgField;
	
	public LoginParameterException() {
		msgField = new HashMap<String, String>();
	}
	
	public LoginParameterException(int code, String message)
	{
		this.code = code;
		msgField = new HashMap<String, String>();
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}

	public HashMap<String, String> getMsgField() {
		return msgField;
	}

	public void setMsgField(HashMap<String, String> msgField) {
		this.msgField = msgField;
	}
}
