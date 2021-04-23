package com.bootcamp.reservation_boot.config;

import com.bootcamp.reservation_api.repository.FakeReservationRepository;
import com.bootcamp.reservation_api.repository.ReservationRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReservationAppConfig {

    @Bean
    public ReservationRepository reservationRepository() {
        return new FakeReservationRepository();
    }
}
