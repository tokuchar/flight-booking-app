package com.bootcamp.reservation.config;

import com.bootcamp.reservation.repository.ReservationRepository;
import com.bootcamp.reservation.repository.ReservationRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReservationAppConfig {

    @Bean
    public ReservationRepository reservationRepository() {
        return new ReservationRepositoryImpl();
    }
}
