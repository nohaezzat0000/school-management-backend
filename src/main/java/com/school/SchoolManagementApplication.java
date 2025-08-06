package com.school;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableCaching
public class SchoolManagementApplication {

	public static void main(String[] args) {
		System.out.println("encode");
		System.out.println(new BCryptPasswordEncoder().encode("admin123"));
		boolean matches = new BCryptPasswordEncoder().matches("admin123", "");
		System.out.println("Matches: " + matches);
		SpringApplication.run(SchoolManagementApplication.class, args);
	}

}
