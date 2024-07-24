package com.example.SitePGE;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class SitePgeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SitePgeApplication.class, args);
	}

}
