package com.cts.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class StudentBean implements Serializable{

	
	private String name;
	private String address;
	
	@Id
	private String email;
	private String password;
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	
	 @JoinTable(name = "students_courses",
     joinColumns = {
             @JoinColumn(name = "student_id", referencedColumnName = "email")
	 				},
     inverseJoinColumns = {
             @JoinColumn(name = "course_id", referencedColumnName = "courseId")
	 })
	private List<CourseBean> courses=new ArrayList<CourseBean>();
	
	
	
	
	
	public List<CourseBean> getCourses() {
		return courses;
	}


	public void setCourses(List<CourseBean> courses) {
		this.courses = courses;
	}


	public StudentBean() {
		// TODO Auto-generated constructor stub
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
	
	
}
