package com.cts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;

@SpringBootApplication
public class StudentregistrationprojectfinalprojectApplication {

	
	@Bean
	public ResourceBundleViewResolver viewResolver() {
		
		ResourceBundleViewResolver rb=new ResourceBundleViewResolver();
		
		rb.setBasename("views");
		
		rb.setOrder(1);
		
		return rb;
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(StudentregistrationprojectfinalprojectApplication.class, args);
	}

	
	
	
}
