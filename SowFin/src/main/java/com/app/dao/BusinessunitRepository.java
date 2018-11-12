package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.model.BusinessUnit;
import java.lang.String;
@Repository
public interface BusinessunitRepository extends JpaRepository<BusinessUnit, Integer>{
	@Query("select t from BusinessUnit t where t.id = :id and status='1'")
	BusinessUnit	findById(int id);
	@Query("select t from BusinessUnit t where t.id = :id and status='1'")
	List<BusinessUnit>	findById1(int id);
	@Query("select t from BusinessUnit t where  status='1'")
	List<BusinessUnit>	findAll1();
	@Query("select t from BusinessUnit t where  status='0'")
	List<BusinessUnit>	getInactive();
	List<BusinessUnit>	findAll();
	List<BusinessUnit> findByName(String name);
	List<BusinessUnit> findByNameOrId(String name,int id);
	List<BusinessUnit> findByNameOrDescriptionContainingIgnoreCase(String name,String desc);
	List<BusinessUnit> findByNameOrDescription(String name,String desc);
}
