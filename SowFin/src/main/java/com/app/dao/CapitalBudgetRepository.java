package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.CapitalBudget;

public interface CapitalBudgetRepository extends JpaRepository<CapitalBudget, Integer>{
	
}
