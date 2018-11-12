package com.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="valuation_method")

public class ValuationMethod {


	 @Id
	    @GeneratedValue(generator = "increment")
	    @GenericGenerator(name= "increment", strategy= "increment")
	private int id;
	private String name;
	public ValuationMethod(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
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
	
	public ValuationMethod() {
		super();
	}
	public ValuationMethod(int id) {
		super();
		this.id = id;
	}
	
	public ValuationMethod(String name) {
		super();
		this.name = name;
	}
	
	
	
}
