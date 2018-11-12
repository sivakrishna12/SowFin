package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.model.Projects;
import java.util.List;
@Repository
public interface ProjectRepository  extends JpaRepository<Projects, Integer> {
	Projects findById(int id);
	@Query("select t from Projects t where t.id = :id")
	List<Projects> findById1(int id);
	//List<Projects> findByCode(String code);

	@Query("select t from Projects t \r\n" + 
			"where t.business_unit.id = :id")
	List<Projects>	findbyBusinessUnitId(int id);
	@Query("select t from Projects t \r\n" + 
			"where t.business_unit.id = :bid and t.id = :id")
	List<Projects> findBybIdandid(int bid,int id);
	
}