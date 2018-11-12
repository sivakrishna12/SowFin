package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ValuationRepository;
import com.app.model.ValuationMethod;

@Service
public class ValuationService {
	@Autowired
private ValuationRepository rep;
	public ValuationMethod addUser(ValuationMethod unit) {
		
		return rep.save(unit);
		
	}


	public List<ValuationMethod> getAllUsers() {
		
		return rep.findAll();
	}

	public boolean AllUsersExist() {
		


	List<?> count=rep.findAll();


		if(!(count.isEmpty())) {
			
			return true;
		}else {
			return false;
		}
	}

	public boolean getById1Exist(int id) {
		


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
	 
	    public ValuationMethod editUser(ValuationMethod s) {
	    	
	        return rep.saveAndFlush(s);
	    }

	public ValuationMethod getById(int id) {
	    return rep.findById(id);
	}
	public List<ValuationMethod> getById1(int id) {
	    return rep.findById1(id);
	}
	
	
	
}
