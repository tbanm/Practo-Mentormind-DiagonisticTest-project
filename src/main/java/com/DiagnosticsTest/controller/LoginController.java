package com.DiagnosticsTest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class LoginController {


	@GetMapping("/showMyLoginPage")
	public String showHome()
	{
		
		return "login";
	}

	
/*
	@RequestMapping("/authenticateTheUser")
	public String shwHome()
	{
		
		return "user/success";
	}

       */
}

