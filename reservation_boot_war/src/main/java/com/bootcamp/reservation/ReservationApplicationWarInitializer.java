package com.bootcamp.reservation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ReservationApplicationWarInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ReservationApplicationWarInitializer.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(ReservationApplicationWarInitializer.class, args);
    }
}
