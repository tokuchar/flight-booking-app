package com.bootcamp.reservation.repository;

import com.bootcamp.reservation.model.Reservation;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ReservationRepository {
    UUID createReservation(Reservation reservation);
    Optional<Reservation> findReservation(UUID uuid);
    List<Reservation> findAllReservations();
}
