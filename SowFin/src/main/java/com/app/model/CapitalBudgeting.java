package com.app.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="capital_budget_fields")
public class CapitalBudgeting {
	 @Id
	    @GeneratedValue(generator = "increment")
	    @GenericGenerator(name= "increment", strategy= "increment")
	private int id;

@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
@JoinColumn(name = "capid", referencedColumnName="id")
private List<CapitalBudget> budget;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public List<CapitalBudget> getBudget() {
	return budget;
}
public void setBudget(List<CapitalBudget> budget) {
	this.budget = budget;
}
public CapitalBudgeting(int id, List<CapitalBudget> budget) {
	super();
	this.id = id;
	this.budget = budget;
}
public CapitalBudgeting() {
	super();
}

public CapitalBudgeting(int id) {
	super();
	this.id = id;
}


}
