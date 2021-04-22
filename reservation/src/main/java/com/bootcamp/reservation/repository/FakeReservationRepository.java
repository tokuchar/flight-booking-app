package com.bootcamp.reservation.repository;

import com.bootcamp.reservation.model.Reservation;
import lombok.AllArgsConstructor;

import java.util.*;

@AllArgsConstructor
public class FakeReservationRepository{
    private static Map<UUID, Reservation> reservations = new HashMap<>();

    public UUID createReservation(Reservation reservation) {
        UUID id = UUID.randomUUID();
        reservation.setUuid(id);
        reservations.put(id, reservation);
        return id;
    }

    public Optional<Reservation> findReservation(UUID uuid) {
        return Optional.ofNullable(reservations.get(uuid));
    }

    public List<Reservation> findAllReservations() {
        return new ArrayList(reservations.values());
    }
}
