package com.cts.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GeneratorType;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="course")
public class CourseBean implements Serializable{
	
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer courseId;

	private String courseName;
	private String duration;
	private Integer fee;
	

	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date startDate;
	private Integer capacity;
	private Integer availability;
	
	
	@ManyToMany(mappedBy = "courses",fetch = FetchType.LAZY)
	private List<StudentBean> students=new ArrayList<StudentBean>();
	
	
	
	

	public List<StudentBean> getStudents() {
		return students;
	}


	public void setStudents(List<StudentBean> students) {
		this.students = students;
	}


	public Integer getAvailability() {
		return availability;
	}


	public void setAvailability(Integer availability) {
		this.availability = availability;
	}


	public CourseBean() {
		// TODO Auto-generated constructor stub
	}


	public Integer getCourseId() {
		return courseId;
	}


	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}


	public String getCourseName() {
		return courseName;
	}


	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}


	public String getDuration() {
		return duration;
	}


	public void setDuration(String duration) {
		this.duration = duration;
	}


	public Integer getFee() {
		return fee;
	}


	public void setFee(Integer fee) {
		this.fee = fee;
	}


	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public Integer getCapacity() {
		return capacity;
	}


	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}


	public CourseBean(Integer courseId, String courseName, String duration, Integer fee, Date startDate,
			Integer capacity, Integer availability, List<StudentBean> students) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.duration = duration;
		this.fee = fee;
		this.startDate = startDate;
		this.capacity = capacity;
		this.availability = availability;
		this.students = students;
	}



	
	
	
	
	
	
	
	
}
