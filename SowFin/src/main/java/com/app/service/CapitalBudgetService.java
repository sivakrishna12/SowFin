package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.CapitalBudgetRepository;
import com.app.model.CapitalBudget;

@Service
public class CapitalBudgetService {

	@Autowired
	private CapitalBudgetRepository rep1;
	
	public CapitalBudget addUser(CapitalBudget unit) {
		
		return rep1.save(unit);
		
	}


	
	public List<CapitalBudget> getAllUsers() {
		
		return rep1.findAll();
	}

	/*public List<CapitalBudget> getById(int id) {
	return rep1.findById(id);

	}*/
	 
}
