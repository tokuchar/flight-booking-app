package com.bootcamp.reservation.config;

import com.bootcamp.reservation.repository.FakeReservationRepository;
import com.bootcamp.reservation.repository.H2DatabaseReservationRepository;
import com.bootcamp.reservation.repository.ReservationRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReservationAppConfig {

    @Bean
    public ReservationRepository reservationRepository() {
        return new H2DatabaseReservationRepository();
    }
}
