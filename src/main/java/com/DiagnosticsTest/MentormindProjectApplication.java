package com.DiagnosticsTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@EntityScan("com.DiagnosticsTest.entity")
@ComponentScan(basePackages = "com.DiagnosticsTest.controller ,"  +"com.DiagnosticsTest.entity," +"com.DiagnosticsTest.service" )
public class MentormindProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MentormindProjectApplication.class, args);
	}

}
