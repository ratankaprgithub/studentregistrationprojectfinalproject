package com.cts.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cts.dao.CourseDao;
import com.cts.dao.StudentDao;
import com.cts.model.CourseBean;
import com.cts.model.StudentBean;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

@Controller
public class StudentController {

	@Autowired
	StudentDao sdao;
	
	@Autowired
	CourseDao cdao;
	
	
	
	@GetMapping("/registerStudent")
	public String launchStudentRegistration(@ModelAttribute("student") StudentBean student) {
		
		
		return "registerStudent";
		
	}
	
	@PostMapping("/addStudent")
	public String addStudent(@ModelAttribute("student")StudentBean student) {
		
		sdao.save(student);
		
		return "studentSucess";
		
	}
	
	@GetMapping("/viewAllCourses")
	public String viewAllCourses(Model m) {
		
		List<CourseBean> clist=cdao.findAll();
		
		m.addAttribute("courses", clist);
		
		
		return "viewAllCourses";
		
		
	}
	
	
	@GetMapping("/enroll")
	public String enrollStudent(@RequestParam("sid")String studentid,@RequestParam("cid")int courseId,Model m) {
		

		Optional<CourseBean> opt= cdao.findById(courseId);
		
		CourseBean course= opt.get();
		
		
		m.addAttribute("course", course);
			
		return "enroll";
	}
	
	@GetMapping("/confirm")
	public String confirm(@RequestParam("cid")int courseId,@RequestParam("sid")String studentId) {
		
		Optional<CourseBean> opt= cdao.findById(courseId);
		CourseBean course=opt.get();
		
		
		Optional<StudentBean> opt2= sdao.findById(studentId);
		StudentBean student=opt2.get();
		
		
		List<CourseBean> list=student.getCourses();
		
		list.add(course);
		
		student.setCourses(list);
		
		course.setAvailability(course.getAvailability()-1);
		sdao.save(student);
		cdao.save(course);
		
		
		return "enrollSucess";
		
	}
	
	
	
	@GetMapping("/enrolledCourses")
	public String viewEnrolledCourses(@RequestParam("sid")String studentId,Model m) {
		
		Optional<StudentBean> opt=sdao.findById(studentId);
		
		StudentBean student=opt.get();
		
		List<CourseBean> courses= student.getCourses();
		
		m.addAttribute("courses", courses);
		
		return "enrolledCourses";
		
	}
	
	@GetMapping("/generateExcel")
	public String generateExcel(Model m,HttpSession session) {
		
		List<CourseBean> clist=(List<CourseBean>)session.getAttribute("courses");
		
		m.addAttribute("courses", clist);
		
		
		return "generateExcel";
	}
	
	
	
}
