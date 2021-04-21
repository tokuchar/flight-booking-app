package com.bootcamp.reservation.repository;

import com.bootcamp.reservation.model.Reservation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.*;

@AllArgsConstructor
public class FakeReservationRepository implements ReservationRepository{
    private static Map<UUID, Reservation> reservations;

    @Override
    public UUID createReservation(Reservation reservation) {
        UUID id = UUID.randomUUID();
        reservation.setUuid(id);
        reservations.put(id, reservation);
        return id;
    }

    @Override
    public Optional<Reservation> findReservation(UUID uuid) {
        return Optional.ofNullable(reservations.get(uuid));
    }

    @Override
    public List<Reservation> findAllReservations() {
        return new ArrayList(reservations.values());
    }
}
