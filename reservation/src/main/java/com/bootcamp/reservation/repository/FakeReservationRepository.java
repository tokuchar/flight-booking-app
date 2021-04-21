package com.bootcamp.reservation.repository;

import com.bootcamp.reservation.model.Reservation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class FakeReservationRepository implements ReservationRepository {
    private static Map<UUID, Reservation> reservations = new HashMap<>();

    @Override
    public void createReservation(Reservation reservation) {
        reservations.put(UUID.randomUUID(), reservation);
    }

    @Override
    public Optional<Reservation> findReservation(UUID uuid) {
        return Optional.of(reservations.get(uuid));
    }

    @Override
    public List<Reservation> findAllReservations() {
        return new ArrayList<>(reservations.values());
    }
}
