package com.backend.backendApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class BackendAppApplication implements CommandLineRunner {
	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(BackendAppApplication.class, args);
		System.out.println("Backend App is Started ");

	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(passwordEncoder.encode("admin"));
	}
}
