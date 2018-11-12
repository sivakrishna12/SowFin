package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.CapitalBudgingRepository;
import com.app.model.CapitalBudgeting;

@Service
public class CapitalBudgingService {
	@Autowired
	private CapitalBudgingRepository rep1;
	
	public CapitalBudgeting addUser(CapitalBudgeting unit) {
		
		return rep1.save(unit);
		
	}


	public List<CapitalBudgeting> getAllUsers() {
		
		return rep1.findAll();
	}

	public void deleteById(int id) {
		rep1.deleteById(id);

	}
	 
	    public CapitalBudgeting editUser(CapitalBudgeting s) {
	    	
	        return rep1.saveAndFlush(s);
	    }

	public CapitalBudgeting getById(int id) {
	    return rep1.findById(id);
	}
	public List<CapitalBudgeting> getById1(int id) {
	    return rep1.findById1(id);
	}

}
