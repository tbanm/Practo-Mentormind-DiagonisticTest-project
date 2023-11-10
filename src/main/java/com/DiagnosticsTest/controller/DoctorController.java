package com.DiagnosticsTest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.DiagnosticsTest.entity.Appointment;
import com.DiagnosticsTest.service.AdminServiceImpl;
import com.DiagnosticsTest.service.AppointmentServiceImpl;
import com.DiagnosticsTest.service.UserService;

@Controller
@RequestMapping("/doctor")
public class DoctorController {

	private UserService userService;

	private AdminServiceImpl adminServiceImpl;
	
	private AppointmentServiceImpl appointmentServiceImpl;

	
	@Autowired
	public DoctorController(UserService userService,AdminServiceImpl obj,
			AppointmentServiceImpl app) {
		this.userService = userService;
		adminServiceImpl=obj;
		appointmentServiceImpl=app;
	}
	
	
	@RequestMapping("/index")
	public String index(Model model, String User){

	
		
		
		com.DiagnosticsTest.entity.Admin admin = adminServiceImpl.findByEmail(User);
	 
		   
		         adminServiceImpl.save(admin);
		
		
		         
		List<Appointment> list=appointmentServiceImpl.findAll();
		
		model.addAttribute("name",admin.getFirstName());
		
		model.addAttribute("email",admin.getEmail());
		
		
		model.addAttribute("user",admin.getFirstName()+" "+admin.getLastName());
		
		// add to the spring model
		model.addAttribute("app", list);
		
		return "doctor/index";
	}
	
	
}