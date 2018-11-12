package com.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="capitalbudget")
public class CapitalBudget {
	 @Id
	    @GeneratedValue(generator = "increment")
	    @GenericGenerator(name= "increment", strategy= "increment")
	private int id;
private String field1;
private String field2;
private String field3;
private String field4;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getField1() {
	return field1;
}
public void setField1(String field1) {
	this.field1 = field1;
}
public String getField2() {
	return field2;
}
public void setField2(String field2) {
	this.field2 = field2;
}
public String getField3() {
	return field3;
}
public void setField3(String field3) {
	this.field3 = field3;
}
public String getField4() {
	return field4;
}
public void setField4(String field4) {
	this.field4 = field4;
}
public CapitalBudget(int id, String field1, String field2, String field3, String field4) {
	super();
	this.id = id;
	this.field1 = field1;
	this.field2 = field2;
	this.field3 = field3;
	this.field4 = field4;
}
public CapitalBudget() {
	super();
}
public CapitalBudget(int id) {
	super();
	this.id = id;
}

}
