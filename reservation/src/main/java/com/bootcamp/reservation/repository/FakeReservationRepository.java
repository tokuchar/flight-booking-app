package com.bootcamp.reservation.repository;

import com.bootcamp.reservation.model.Reservation;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class FakeReservationRepository implements ReservationRepository {
    private static Map<UUID, Reservation> reservations;

    public FakeReservationRepository() {
        reservations = new HashMap<>();
    }

    @Override
    public UUID createReservation(Reservation reservation) {
        while(true) {
            UUID uuid = UUID.randomUUID();
            if (!reservations.containsKey(uuid)) {
                reservations.put(uuid, reservation);
                return uuid;
            }
        }
    }

    @Override
    public Optional<Reservation> findReservation(UUID uuid) {
        return Optional.ofNullable(reservations.get(uuid));
    }

    @Override
    public List<Reservation> findAllReservations() {
        return reservations.values().stream().collect(Collectors.toUnmodifiableList());
    }
}
