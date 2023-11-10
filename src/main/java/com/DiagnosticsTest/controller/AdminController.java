package com.DiagnosticsTest.controller;


import java.util.List;

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
@RequestMapping("/admin")
public class AdminController {
	
    @Autowired
	private AdminServiceImpl adminServiceImpl;
	@Autowired
	private AppointmentServiceImpl appointmentServiceImpl;
	private String User;

	
	
	
	@RequestMapping("/user-details")
	public String index(Model model){
		
		
		List<Admin> list=adminServiceImpl.findByRole("ROLE_USER");
		model.addAttribute("user", list);
		
		
		Admin admin = adminServiceImpl.findByEmail(User);
		         adminServiceImpl.save(admin);
		   return "admin/user";
		   
		   
	}
	
	@RequestMapping("/doctor-details")
	public String doctorDetails(Model model){
		
		
		Admin admin = adminServiceImpl.findByEmail(User);
		
		         adminServiceImpl.save(admin);
		
		List<Admin> list=adminServiceImpl.findByRole("ROLE_DOCTOR");
		
		
		
		// add to the spring model
		model.addAttribute("user", list);
		
		
		return "admin/doctor";
	}
	
	@RequestMapping("/admin-details")
	public String adminDetails(Model model){
		
		
		Admin admin = adminServiceImpl.findByEmail(User);
		     adminServiceImpl.save(admin);
		         
		List<Admin> list=adminServiceImpl.findByRole("ROLE_ADMIN");
		// add to the spring model
		model.addAttribute("user", list);
		
		
		return "admin/admin";
	}
	
	
	@GetMapping("/add-doctor")
	public String showFormForAdd(Model theModel) {
		
		
		Admin admin1 = adminServiceImpl.findByEmail(User);
				 
			 
		   
		         adminServiceImpl.save(admin1);
		
		
		// create model attribute to bind form data
		
		
		theModel.addAttribute("doctor", admin1);
		
		return "admin/addDoctor";
	}
	
	
	@PostMapping("/save-doctor")
	public String saveEmployee(@ModelAttribute("doctor") Admin admin) {
		
		// save the employee
	//	admin.setId(0);
		
		admin.setRole("ROLE_DOCTOR");
		
		admin.setPassword("default");
		
		admin.setEnabled(true);
		
		admin.setConfirmationToken("ByAdmin-Panel");
		
		System.out.println(admin);
		
		adminServiceImpl.save(admin);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/admin/userdetails";
	}
	
	

	@GetMapping("/add-admin")
	public String showForm(Model theModel) {
		
		Admin admin1 = adminServiceImpl.findByEmail(User);
		         adminServiceImpl.save(admin1);
		
		// create model attribute to bind form data
		
		
		theModel.addAttribute("doctor", admin1);
		
		return "admin/addAdmin";
	}
	
	
	@PostMapping("/save-admin")
	public String saveEmploye(@ModelAttribute("doctor") Admin admin) {
		
		// save the employee
	//	admin.setId(0);
		
		admin.setRole("ROLE_ADMIN");
		
		admin.setPassword("default");
		
		admin.setEnabled(true);
		
		admin.setConfirmationToken("ByAdmin-Panel");
		
		System.out.println(admin);
		
		adminServiceImpl.save(admin);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/admin/userdetails";
	}
	
	@GetMapping("/edit-my-profile")
	public String EditForm(Model theModel) {
		
		
		// get the employee from the service
		
		Admin admin = adminServiceImpl.findByEmail(User);
	         adminServiceImpl.save(admin);
		
		System.out.println(admin);
		
		theModel.addAttribute("profile", admin);
		
		return "admin/updateMyProfile";
		
	}
			
	
	@PostMapping("/update")
	public String update(@ModelAttribute("profile") Admin admin) {
		
		
		System.out.println(admin);
		
		adminServiceImpl.save(admin);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/admin/user-details";
	}
	
	
	@RequestMapping("/appointments")
	public String appointments(Model model){
		
		Admin admin = adminServiceImpl.findByEmail(User);
	         adminServiceImpl.save(admin);
		         
		List<Appointment> list=appointmentServiceImpl.findAll();
		// add to the spring model
		model.addAttribute("app", list);
		
		return "admin/appointment";
	}
}
