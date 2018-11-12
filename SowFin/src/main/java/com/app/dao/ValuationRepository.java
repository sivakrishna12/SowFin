package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.model.ValuationMethod;
@Repository
public interface ValuationRepository extends JpaRepository<ValuationMethod, Integer>{
	ValuationMethod findById(int id);
	@Query("select t from ValuationMethod t where id = :id")
	List<ValuationMethod> findById1(int id);
}
