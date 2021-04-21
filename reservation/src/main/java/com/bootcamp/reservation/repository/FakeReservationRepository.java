package com.bootcamp.reservation.repository;

import com.bootcamp.reservation.model.Reservation;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
public class FakeReservationRepository implements ReservationRepository {
    //TODO: zaimplementować metody :)
    private Map<UUID, Reservation> reservations;

    @Override
    public UUID createReservation(Reservation reservation) {
        return null;
    }

    @Override
    public Optional<Reservation> findReservation(UUID uuid) {
        return Optional.empty();
    }

    @Override
    public List<Reservation> findAllReservations() {
        return null;
    }
}
