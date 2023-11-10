package com.DiagnosticsTest.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.DiagnosticsTest.entity.Admin;
import com.DiagnosticsTest.entity.Appointment;

import com.DiagnosticsTest.service.AdminServiceImpl;
import com.DiagnosticsTest.service.AppointmentServiceImpl;

@Controller
@RequestMapping("/user")
public class UserController {

	private static final String User = null;

	private AppointmentServiceImpl appointmentServiceImpl;

	private AdminServiceImpl adminServiceImpl;
	
	@Autowired
	public UserController(AppointmentServiceImpl obj1,AdminServiceImpl obj ) {
		appointmentServiceImpl= obj1;
		adminServiceImpl=obj;
		 
	}
	
	@GetMapping("/index")
	public String index(Model model, String user){
		
		
		
		Admin admin = adminServiceImpl.findByEmail(user);
		
		         adminServiceImpl.save(admin);
		
		 
		         
		 Appointment obj=new Appointment();
		 
		 obj.setName(admin.getFirstName()+" "+admin.getLastName());
		 
		 obj.setEmail(admin.getEmail());
			
		 System.out.println(obj);
		 
		 model.addAttribute("app",obj);
		
		return "user/index";
	}
	
	@PostMapping("/save-app")
	public String saveEmploye(@ModelAttribute("app") Appointment obj) {
		
		appointmentServiceImpl.save(obj);
		
	
		// use a redirect to prevent duplicate submissions
		return "redirect:/user/index";
	}

	
	@GetMapping("/about")
	public String about(Model model){
		
		
		Admin admin = adminServiceImpl.findByEmail(User);
			
		         adminServiceImpl.save(admin);
		
		 
		         
		 Appointment obj=new Appointment();
		 
		 obj.setName(admin.getFirstName()+" "+admin.getLastName());
		 
		 obj.setEmail(admin.getEmail());
			
		 System.out.println(obj);
		 
		 model.addAttribute("app",obj);
		 
		return "user/about";
	}
	
	@GetMapping("/blog-single")
	public String bs(Model model){
		
		
		
		Admin admin = adminServiceImpl.findByEmail(User);
				 
			 
		         adminServiceImpl.save(admin);
		
		 
		         
		 Appointment obj=new Appointment();
		 
		 obj.setName(admin.getFirstName()+" "+admin.getLastName());
		 
		 obj.setEmail(admin.getEmail());
			
		 System.out.println(obj);
		 
		 model.addAttribute("app",obj);
		 
		return "user/blog-single";
	}
	
	@GetMapping("/blog")
	public String blog(Model model){
		
		
		
		Admin admin = adminServiceImpl.findByEmail(User);
				 
			
		         adminServiceImpl.save(admin);
		
		 
		         
		 Appointment obj=new Appointment();
		 
		 obj.setName(admin.getFirstName()+" "+admin.getLastName());
		 
		 obj.setEmail(admin.getEmail());
			
		 System.out.println(obj);
		 
		 model.addAttribute("app",obj);
		
		return "user/blog";
	}
	
	@GetMapping("/contact")
	public String contact(Model model){
		
		
		Admin admin = adminServiceImpl.findByEmail(User);
				 
			    adminServiceImpl.save(admin);
		
		 
		         
		 Appointment obj=new Appointment();
		 
		 obj.setName(admin.getFirstName()+" "+admin.getLastName());
		 
		 obj.setEmail(admin.getEmail());
			
		 System.out.println(obj);
		 
		 model.addAttribute("app",obj);
		
		return "user/contact";
	}
	

	@GetMapping("/department-single")
	public String d(Model model){
		
		
		
		Admin admin = adminServiceImpl.findByEmail(User);
				 
			   adminServiceImpl.save(admin);
		
		 
		         
		 Appointment obj=new Appointment();
		 
		 obj.setName(admin.getFirstName()+" "+admin.getLastName());
		 
		 obj.setEmail(admin.getEmail());
			
		 System.out.println(obj);
		 
		 model.addAttribute("app",obj);

		
		return "user/department-single";
	}

	@GetMapping("/departments")
	public String dep(Model model){
		
		
		
		Admin admin = adminServiceImpl.findByEmail(User);
			  adminServiceImpl.save(admin);
		
		 
		         
		 Appointment obj=new Appointment();
		 
		 obj.setName(admin.getFirstName()+" "+admin.getLastName());
		 
		 obj.setEmail(admin.getEmail());
			
		 System.out.println(obj);
		 
		 model.addAttribute("app",obj);
		
		return "user/departments";
	}

	@GetMapping("/doctor")
	public String doctor(Model model){
		
		
		Admin admin = adminServiceImpl.findByEmail(User);
		         adminServiceImpl.save(admin);
		
		         
		 Appointment obj=new Appointment();
		 
		 obj.setName(admin.getFirstName()+" "+admin.getLastName());
		 
		 obj.setEmail(admin.getEmail());
			
		 System.out.println(obj);
		 
		 model.addAttribute("app",obj);

		
		return "user/doctor";
	}
}