package com.app.util;

import java.util.List;

public class Status {
	private int status;
	private List<?> active;
	private List<?> inactive;
	private String error;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public List<?> getActive() {
		return active;
	}
	public void setActive(List<?> active) {
		this.active = active;
	}
	public List<?> getInactive() {
		return inactive;
	}
	public void setInactive(List<?> inactive) {
		this.inactive = inactive;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public Status(int status, List<?> active, List<?> inactive, String error) {
		super();
		this.status = status;
		this.active = active;
		this.inactive = inactive;
		this.error = error;
	}
	public Status() {
		super();
	}
	public Status(int status, String error) {
		super();
		this.status = status;
		this.error = error;
	}
	

}
