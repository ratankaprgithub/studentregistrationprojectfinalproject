package com.cts.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cts.model.CourseBean;

public interface CourseDao extends JpaRepository<CourseBean,Integer>{
	
	@Query("select c.courseName from CourseBean c")
	public List<String> findAllCurseNames();
	
	@Query("select c from CourseBean c where c.courseName=:cname")
	public CourseBean findCourseByName(String cname);
	
	@Query("select c.availability from CourseBean c where c.courseId=:id")
	public int getAvailabilitybyCourseID(int id);
	
	
	@Query("select c.capacity from CourseBean c where c.courseId=:id")
	public int getCapacityByCourseID(int id);
	

	
	
}
