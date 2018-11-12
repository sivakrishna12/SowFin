package com.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="BusinessUnit")
public class BusinessUnit {
	 @Id
	    @GeneratedValue(generator = "increment")
	    @GenericGenerator(name= "increment", strategy= "increment")
	private int id;
	
	private String name;
	private String description;
	
	private String yearestablished;
	
	   private String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getYearestablished() {
		return yearestablished;
	}

	public void setYearestablished(String yearestablished) {
		this.yearestablished = yearestablished;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	public BusinessUnit() {
		super();
	}

	public BusinessUnit(int id) {
		super();
		this.id = id;
	}

	public BusinessUnit(int id, String name, String description, String yearestablished, String status) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.yearestablished = yearestablished;
		this.status = status;
	}

	
	
	
}	   
