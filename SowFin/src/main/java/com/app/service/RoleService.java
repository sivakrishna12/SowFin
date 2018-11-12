package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.RoleRepository;
import com.app.model.Roles;

@Service
public class RoleService {
	@Autowired
	private RoleRepository stu;
	
	public Roles getActiveRole(int id) {
	
	return stu.findById(id);
	
	}
	
	public boolean roleExist(int id) {
		
		List<?> list=stu.findById1(id);
	
		if(!(list.isEmpty())) {
			
			return true;
		}else {
			return false;
		}
	}
	
	public boolean RoleExists(String role){
		List<Roles> count= stu.findByRole(role);
		if(!(count.isEmpty())) {
			return true;
		}else {
			return false;
		}
	}
	
	/*public List<Roles> getByRolel(String role) {
		Roles userInfo = new Roles();
		
		List<?> list =stu.findByRole(role);
		if (!list.isEmpty()) {
			userInfo = (Roles) list.get(0);
		}
		return userInfo;
		return stu.findByRole(role);
	}
	*/
	
	
	public Roles addRoles(Roles roles) {
		
		
		return stu.save(roles);
		
	}
	

	 
	    public Roles editUser(Roles s) {
	    
	        return stu.saveAndFlush(s);
	    }

	
	 public List<Roles> getActicve() {
	    	
	    		return stu.findByActive();
	    	
	    }
	 public boolean ActicveExist() {

			List<?> list=stu.findByActive();
		

			if(!(list.isEmpty())) {
				
				return true;
			}else {
				return false;
			}
		}
	 public List<Roles> findbyid1(int id) {
		
		 return stu.findById1(id);
		 
	 }
}
