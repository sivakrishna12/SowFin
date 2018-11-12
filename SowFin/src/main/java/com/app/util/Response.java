package com.app.util;

import java.util.List;

public class Response {
private int status;
private List<?> response;
private String error;
public Response(int status, List<?> response, String error) {
	super();
	this.status = status;
	this.response = response;
	this.error = error;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}
public List<?> getResponse() {
	return response;
}
public void setResponse(List<?> response) {
	this.response = response;
}
public String getError() {
	return error;
}
public void setError(String error) {
	this.error = error;
}
public Response() {
	super();
}

}
