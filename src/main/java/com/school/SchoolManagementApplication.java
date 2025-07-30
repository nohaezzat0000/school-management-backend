package com.school;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SchoolManagementApplication {

	public static void main(String[] args) {
		System.out.println("يبيليلل");
		System.out.println(new BCryptPasswordEncoder().encode("admin123"));
		System.out.println("لبيليبلبيل");
		boolean matches = new BCryptPasswordEncoder().matches("admin123", "$2a$10$TqYNq8rH5dvgVsJ9.F0xLuVZDEo.rVk66rm4O/v67xVHNMvW1q1PO");
		System.out.println("Matches: " + matches);
		SpringApplication.run(SchoolManagementApplication.class, args);
	}

}
