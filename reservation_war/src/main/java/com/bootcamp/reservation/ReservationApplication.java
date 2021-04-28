package com.bootcamp.reservation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ReservationApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(ReservationApplication.class, args);
    }
}
