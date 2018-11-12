package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.model.CapitalBudgeting;
@Repository
public interface CapitalBudgingRepository extends JpaRepository<CapitalBudgeting, Integer>{

	CapitalBudgeting	findById(int id);
	@Query("select t from CapitalBudgeting t where t.id = :id")
	List<CapitalBudgeting> findById1(int id);
}
