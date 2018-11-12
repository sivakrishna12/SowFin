package com.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="projects")
public class Projects {

	 @Id
	    @GeneratedValue(generator = "increment")
	    @GenericGenerator(name= "increment", strategy= "increment")
	
	 private int id;
	 private String name;
	 private String description;
	 @ManyToOne
	 private BusinessUnit business_unit;
	 @ManyToOne
	private  ValuationMethod Valuation_method;
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
	public BusinessUnit getBusiness_unit() {
		return business_unit;
	}
	public void setBusiness_unit(BusinessUnit business_unit) {
		this.business_unit = business_unit;
	}
	public ValuationMethod getValuation_method() {
		return Valuation_method;
	}
	public void setValuation_method(ValuationMethod valuation_method) {
		Valuation_method = valuation_method;
	}
	public Projects(int id, String name,  String description, BusinessUnit business_unit,
			ValuationMethod valuation_method) {
		super();
		this.id = id;
		this.name = name;
		
		this.description = description;
		this.business_unit = business_unit;
		Valuation_method = valuation_method;
	}
	public Projects() {
		super();
	}
	public Projects(int id) {
		super();
		this.id = id;
	}
	
}
