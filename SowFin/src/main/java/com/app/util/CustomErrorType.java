package com.app.util;

public class CustomErrorType {
private int status;

    public int getStatus() {
	return status;
}

public void setStatus(int status) {
	this.status = status;
}

	private String Message;
   

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	public CustomErrorType(String message) {
		super();
		Message = message;
	}

	public CustomErrorType() {
		super();
	}

	public CustomErrorType(int status, String message) {
		super();
		this.status = status;
		Message = message;
	}

	public CustomErrorType(int status) {
		super();
		this.status = status;
	}

	
   

}