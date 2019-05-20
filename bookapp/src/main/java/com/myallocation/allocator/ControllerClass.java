package com.myallocation.allocator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControllerClass {
	@Autowired
	ServiceRegister serv;
	
	@RequestMapping("/register")
	public ModelAndView home() {
		ModelAndView mv=new ModelAndView();
		mv.addObject("students",new Student());
		return mv;
	}
	
	@RequestMapping("/submit")
	public ModelAndView myhome(Student student) {
		ModelAndView mv=new ModelAndView();
	     serv.save(student);
		mv.addObject("students",new Student());
		mv.setViewName("login");
		return mv;
	}
	@RequestMapping("/login")
	public ModelAndView login(@RequestParam String username,@RequestParam String password) {
		ModelAndView mv=new ModelAndView();
	     serv.myStudent(username,password);
	     if(serv.myStudent(username,password)!=null) {
	    	 
		mv.addObject("student", serv.myStudent(username,password));
		mv.setViewName("welcome");
	     }
	     else {
	    String message="invalid login details!";
	    mv.addObject("message",message);
	    mv.addObject("students",new Student());
	    mv.setViewName("login");	 
	     }
		return mv;
	}
	
	
}
