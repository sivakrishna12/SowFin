package com.app.util;

public class Output {
	private int status;
	
private ResponseCode response;
private String error;
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}
public ResponseCode getResponse() {
	return response;
}
public void setResponse(ResponseCode response) {
	this.response = response;
}
public String getError() {
	return error;
}
public void setError(String error) {
	this.error = error;
}
public Output(int status, ResponseCode response, String error) {
	super();
	this.status = status;
	this.response = response;
	this.error = error;
}
public Output() {
	super();
}
public Output(int status, String error) {
	super();
	this.status = status;
	this.error = error;
}



}
