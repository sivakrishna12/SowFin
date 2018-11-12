package com.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="roles")
public class Roles {
	 @Id
	    @GeneratedValue(generator = "increment")
	    @GenericGenerator(name= "increment", strategy= "increment")
	 private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	private String role;
	
	 private String active;
	
	 private String deleted;
	 
	public String getDeleted() {
		return deleted;
	}
	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public Roles(String role, String active) {
		super();
		this.role = role;
		this.active = active;
	}
	public Roles() {
		super();
	}
	/*@Override
	public String toString() {
		return "Roles [role=" + role + ", active=" + active + "]";
	}
*/

	public Roles(int id, String role) {
		super();
		this.id = id;
		this.role = role;
	}
	public Roles(int id) {
		super();
		this.id = id;
	}
	public Roles(int id, String role, String active) {
		super();
		this.id = id;
		this.role = role;
		this.active = active;
	}
	public Roles(int id, String role, String active, String deleted) {
		super();
		this.id = id;
		this.role = role;
		this.active = active;
		this.deleted = deleted;
	}
	
	 
}
