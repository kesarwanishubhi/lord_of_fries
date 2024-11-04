package com.shubhi.lord_of_fries;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class LordOfFriesApplication {

	public static void main(String[] args) {
		SpringApplication.run(LordOfFriesApplication.class, args);
	}

}
