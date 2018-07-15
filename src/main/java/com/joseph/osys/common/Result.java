package com.joseph.osys.common;

public class Result {
    private boolean success;
    private String info;
    private Object data;
    
	public Result(boolean success, String info, Object data) {
		super();
		this.success = success;
		this.info = info;
		this.data = data;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
    
}