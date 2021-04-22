package com.bootcamp.reservation.repository;

import com.bootcamp.reservation.model.ReservationEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ReservationRepository {
    UUID createReservation(ReservationEntity reservation);
    Optional<ReservationEntity> findReservation(UUID uuid);
    List<ReservationEntity> findAllReservations();
}
