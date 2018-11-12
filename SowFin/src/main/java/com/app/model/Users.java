package com.app.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
	
	@Entity
	@Table(name="users")
	public class Users {
		 @Id
		    @GeneratedValue(generator = "increment")
		    @GenericGenerator(name= "increment", strategy= "increment")
		
		
		 private int id;
		
		 private String username;
		
			private String password;
		
			private String email;
		
			private Date created_at;
		 
			private Date updated_at;
			@ManyToOne
			private Roles role;
			
			
		
			public Roles getRole() {
				return role;
			}
			public void setRole(Roles role) {
				this.role = role;
			}
			private String active;
			public String deleted;
			public int getId() {
				return id;
			}
			public void setId(int id) {
				this.id = id;
			}
			public String getUsername() {
				return username;
			}
			public void setUsername(String username) {
				this.username = username;
			}
			public String getPassword() {
				return password;
			}
			public void setPassword(String password) {
				this.password = password;
			}
			public String getEmail() {
				return email;
			}
			public void setEmail(String email) {
				this.email = email;
			}
			public Date getCreated_at() {
				return created_at;
			}
			public void setCreated_at(Date created_at) {
				this.created_at = created_at;
			}
			public Date getUpdated_at() {
				return updated_at;
			}
			public void setUpdated_at(Date updated_at) {
				this.updated_at = updated_at;
			}
			public String getActive() {
				return active;
			}
			public void setActive(String active) {
				this.active = active;
			}
			public String getDeleted() {
				return deleted;
			}
			public void setDeleted(String deleted) {
				this.deleted = deleted;
			}
			
		public Users(int id, String username, String password, String email, Date created_at, Date updated_at,
					Roles role, String active, String deleted) {
				super();
				this.id = id;
				this.username = username;
				this.password = password;
				this.email = email;
				this.created_at = created_at;
				this.updated_at = updated_at;
				this.role = role;
				this.active = active;
				this.deleted = deleted;
			}
		
			public Users(int id, String username, String password, String email, Roles role, String active,
				String deleted) {
			super();
			this.id = id;
			this.username = username;
			this.password = password;
			this.email = email;
			this.role = role;
			this.active = active;
			this.deleted = deleted;
		}
			public Users() {
				super();
			}
			public Users(int id, String username, String password, String email, String active, String deleted) {
				super();
				this.id = id;
				this.username = username;
				this.password = password;
				this.email = email;
				this.active = active;
				this.deleted = deleted;
			}
			public Users(int id, String email) {
				super();
				this.id = id;
				this.email = email;
			}
			
			
			
			
			
}
