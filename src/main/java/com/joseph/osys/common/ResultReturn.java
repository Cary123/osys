package com.joseph.osys.common;

import java.util.HashMap;

public class ResultReturn {
	private int returnCode;
	private HashMap<String, Object> field;
	
	public ResultReturn() {
		field = new HashMap<String, Object>();
	}
	
	public ResultReturn(int code,String key, Object obj)
	{
		this.returnCode = code;
		field = new HashMap<String, Object>();
		field.put(key, obj);
	}
	public void setCodeAndContent(int code,String key, Object obj)
	{
		this.returnCode = code;
		if(field == null){
			field = new HashMap<String, Object>();
		}
		field.put(key, obj);
	}
	public int getReturnCode() {
		return returnCode;
	}
	public void setReturnCode(int code) {
		this.returnCode = code;
	}

	public HashMap<String, Object> getfield() {
		return field;
	}

	public void setMapField(String key, Object value) {
		if(field == null){
			field = new HashMap<String, Object>();
		}
			field.put(key, value);
	}
	
	public void setfield(HashMap<String, Object> field) {
		this.field = field;
	}

	@Override
	public String toString() {
		return "ResultReturn [returnCode=" + returnCode + ", field=" + field
				+ "]";
	}
	
}
