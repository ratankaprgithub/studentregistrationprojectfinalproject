package com.cts.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cts.model.StudentBean;

@Repository
public interface StudentDao extends JpaRepository<StudentBean, String> {

	@Query("select s from StudentBean s where s.email=:username AND s.password=:password")
	public StudentBean validateStudent(String username,String password);
	
}
