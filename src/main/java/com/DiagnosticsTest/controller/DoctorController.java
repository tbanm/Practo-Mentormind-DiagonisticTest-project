package com.DiagnosticsTest.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
	public String index(Model model){

	
		
		// get last seen
		String username="Tanmoy";
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
		   username = ((UserDetails)principal).getUsername();
		  String Pass = ((UserDetails)principal).getPassword();
		  System.out.println("One + "+username+"   "+Pass);
		  
		  
		} else {
		 username = principal.toString();
		  System.out.println("Two + "+username);
		}
		
		com.DiagnosticsTest.entity.Admin admin = adminServiceImpl.findByEmail(username);
				 
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		    Date now = new Date();  
		    
		         String log=now.toString();
		    
		         admin.setLastseen(log);
		         
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