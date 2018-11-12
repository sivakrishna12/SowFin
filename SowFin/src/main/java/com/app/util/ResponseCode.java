package com.app.util;

public class ResponseCode {
private String responsecode;
private String message;
private int id;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getResponsecode() {
	return responsecode;
}
public void setResponsecode(String responsecode) {
	this.responsecode = responsecode;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public ResponseCode(String responsecode, String message) {
	super();
	this.responsecode = responsecode;
	this.message = message;
}
public ResponseCode() {
	super();
}
public ResponseCode(String responsecode, String message, int id) {
	super();
	this.responsecode = responsecode;
	this.message = message;
	this.id = id;
}

}
