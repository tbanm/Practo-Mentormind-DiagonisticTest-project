package com.DiagnosticsTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class MentormindProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MentormindProjectApplication.class, args);
	}

}
