package com.cts.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cts.dao.CourseDao;
import com.cts.model.CourseBean;

@Controller
public class CourseController {

		@Autowired
		CourseDao cdao;	

		
		@InitBinder
		public void handleDate(WebDataBinder binder) {
			
			SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		
			
		
			CustomDateEditor cde=new CustomDateEditor(sdf, false);
			
			binder.registerCustomEditor(Date.class,cde);
			
			System.out.println("dsddsds");
			
		
		}







	@ModelAttribute("courses")
	public List<String> getCoursesNames(){
	
		
		List<String> clist=cdao.findAllCurseNames();
	
		if(clist.size() >0) {
			return clist;
		}
		
	return null;	
}





	
	@GetMapping("/addCourse")
	public String addNewCourse(@ModelAttribute("course")CourseBean course) {
			
		return "addCourse";
		
	}
	
	@PostMapping("/createCourse")
	public String createCourse(CourseBean course,Model m) {


		course.setAvailability(course.getCapacity());
		
		CourseBean c= cdao.save(course);
		
		m.addAttribute("id", c.getCourseId());
		
		
		return "courseSucess";
	}
	
	
	@GetMapping("/getACourse")
	public String getACourse(@ModelAttribute("course")CourseBean course ) {
		
		return "getACourse";
	}
	
	
	@GetMapping("/getCourseDetails")
	public String getCourseDetails(CourseBean course,Model m) {
				
			course=	cdao.findCourseByName(course.getCourseName());
			
			m.addAttribute("course", course);
				
		return "getCourseDetails";
		
	}
	
	
	@GetMapping("/getAllCourses")
	public String getAllCourses(Model m ) {
		
		List<CourseBean> clist= cdao.findAll();
		
		m.addAttribute("courses",clist);
		
		return "getAllCourses";
	}
	
	
	@GetMapping("/updateCoursePage")
	public String updateCoursePage(Integer cid,Model m) {
		
		Optional<CourseBean> opt= cdao.findById(cid);
		
		CourseBean course=opt.get();
		
		m.addAttribute("course", course);
		
		return "updateCoursePage";
		
	}
	
	
	@PostMapping("/updateCourse")
	public String updateCourse(@ModelAttribute("course") CourseBean course,BindingResult br) {
		
		
		int avail=cdao.getAvailabilitybyCourseID(course.getCourseId());
		
		int cap=cdao.getCapacityByCourseID(course.getCourseId());
		
		int enroll=cap-avail;
		
		if(course.getCapacity()>=enroll) {
		
			course.setAvailability(course.getCapacity()-enroll);
			
			cdao.save(course);
			return "courseUpdateSucess";
		}
		else {
				
			br.addError(new FieldError("course", "capacity", "invalid capacity already "+enroll+" Students Enrolled"));
		
			return "updateCoursePage";
		
		}
	}
	
	
	
	
	
	
}
