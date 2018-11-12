package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.model.Roles;
import java.lang.String;
@Repository
public interface RoleRepository extends JpaRepository<Roles, Integer>{

//	Roles findById(int id);
@Query("SELECT u FROM Roles u WHERE active='1'")
List<Roles> findByActive();
@Query("SELECT u FROM Roles u WHERE active='1' and role=:role")
List<Roles> findByRole(String role);
/*@Query("SELECT u FROM Roles u WHERE active=:'1' and id=:id")
List<Roles> findById1(int id);*/


@Query("SELECT u  FROM Roles u WHERE active='1' and id=:id")
List<Roles> findById1(int id);
@Query("SELECT u  FROM Roles u WHERE active='1' and id=:id")
Roles findById(int id);


}