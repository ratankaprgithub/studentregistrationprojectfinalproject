package com.cts.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cts.dao.StudentDao;
import com.cts.model.LoginBean;
import com.cts.model.StudentBean;

@Controller
public class LoginController {

	@Autowired
	StudentDao sdao;
	
	
	@GetMapping("/")
	public String launchLogin(@ModelAttribute("login")LoginBean login) {
		
		return "home";
	}
	
	
	@PostMapping("/login")
	public ModelAndView signIn(@Valid @ModelAttribute("login")LoginBean loginBean,BindingResult br,HttpSession session) {
		
		ModelAndView mv=new ModelAndView("home", "flag", 1);

		
		
		
		if(br.hasErrors()) {
			
			mv=new ModelAndView("home");
		}
		
	
		if(loginBean.getLoginAs().equals("Admin")) {
			
			if(loginBean.getUsername().equals("Admin")
				&& loginBean.getPassword().equals("Admin"))
			
			mv=new ModelAndView("adminHome");
				
		}
		
		if(loginBean.getLoginAs().equals("Student")) {
			
			StudentBean student=sdao.validateStudent(loginBean.getUsername(), loginBean.getPassword());

			if(student != null)
			{
			mv=new ModelAndView("studentHome");
			session.setAttribute("student", student);
			}
		}
			
		return mv;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
