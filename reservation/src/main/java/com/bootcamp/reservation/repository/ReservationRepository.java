package com.bootcamp.reservation.repository;

import com.bootcamp.reservation.model.Reservation;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ReservationRepository {
    void createReservation(Reservation reservation);
    Optional<Reservation> findReservation(UUID uuid);
    List<Reservation> findAllReservations();
}
