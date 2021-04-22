package com.bootcamp.reservation.repository;

import com.bootcamp.reservation.model.Reservation;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ReservationRepository {
    UUID createReservation(Reservation reservation);
    Optional<Reservation> findReservation(UUID uuid);
    List<Reservation> findAllReservations();
}
