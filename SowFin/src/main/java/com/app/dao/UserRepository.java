package com.app.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.model.Users;
import java.lang.String;
@Repository
@Transactional
public interface UserRepository extends JpaRepository<Users, Integer>{

	
	@Query("SELECT u FROM Users u WHERE active='1'")
	List<Users> findByActive();
	@Query("SELECT t from Users t WHERE t.active ='1' and (t.username=:username or t.email=:email)")
Users findByUsernameOrEmail1(String username,String email);


@Query("select t from Users t where t.id = :id and active='1'")
List<Users> findById(@Param("id") int id);



@Query("select t from Users t where role = :role ")
Users findByRole(int role);


@Query("select t from Users t where t.id = :id and active='1'")
Users findById1(@Param("id") int id);

@Query("SELECT t from Users t WHERE t.active ='1' and (t.username=:username or t.email=:email)")
List<Users> findByUsernameOrEmail(String username,String email);
}
