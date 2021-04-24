package com.bootcamp.reservation.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class WarInitializerApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder builder) {
		return builder.sources(WarInitializerApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication sa = new SpringApplication(
				WarInitializerApplication.class);
		sa.run(args);
	}
}
