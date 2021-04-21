package com.bootcamp.reservation;

import com.bootcamp.reservation.api.ReservationApi;
import com.bootcamp.reservation.model.Reservation;
import com.bootcamp.reservation.model.TicketClass;
import com.bootcamp.reservation.repository.FakeReservationRepository;
import com.bootcamp.reservation.repository.ReservationRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@SpringBootApplication
public class ReservationApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReservationApplication.class, args);

        FakeReservationRepository reservationRepository = new FakeReservationRepository();
        ReservationApi reservationApi = new ReservationApi(reservationRepository);

    }
}
