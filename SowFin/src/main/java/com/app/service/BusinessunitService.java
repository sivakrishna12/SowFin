package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.BusinessunitRepository;
import com.app.model.BusinessUnit;
@Service
public class BusinessunitService {

	@Autowired
	private BusinessunitRepository rep;

	public BusinessUnit addUser(BusinessUnit unit) {
		
		return rep.save(unit);
		
	}
	public List<BusinessUnit> serach(String name,String desc ) {
		//BusinessUnit userInfo = new BusinessUnit();
		
		return rep.findByNameOrDescriptionContainingIgnoreCase(name,  desc);
		
		
	}
	public boolean serachExist(String name,String desc) {
		
	List<?> count=rep.findByNameOrDescription(name, desc);
		
			if(!(count.isEmpty())) {
				
				return true;
			}else {
				return false;
			}
		}
	public List<BusinessUnit> getAllUsers() {
		
		return rep.findAll1();
	}
public List<BusinessUnit> getinactive() {
		
		return rep.getInactive();
	}

public boolean AllUsersExist() {

	List<?> count=rep.findAll();
	
		if(!(count.isEmpty())) {
			
			return true;
		}else {
			return false;
		}
	}
	public boolean businessExist(int id) {
		


	List<?> count=rep.findById1(id);


		if(!(count.isEmpty())) {
			
			return true;
		}else {
			return false;
		}
	}

	
	public void delete(int id) {
		rep.deleteById(id);

	}
	
	
	    public BusinessUnit editUser(BusinessUnit s) {
	    	
	        return rep.saveAndFlush(s);
	    }

	public List<BusinessUnit> getById(int id) {
		return rep.findById1(id);
		
	}
	public BusinessUnit getById1(int id) {
		return rep.findById(id);
	}
	
}
