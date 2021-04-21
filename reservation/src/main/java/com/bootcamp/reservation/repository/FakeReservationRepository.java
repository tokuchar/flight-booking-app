package com.bootcamp.reservation.repository;

import com.bootcamp.reservation.model.Reservation;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class FakeReservationRepository implements ReservationRepository {
    //TODO: zaimplementować metody :)
    private static Map<UUID, Reservation> reservations;

    public FakeReservationRepository() {
        reservations= new HashMap<>();
    }

    @Override
    public UUID createReservation(Reservation reservation) {
        reservations.put(reservation.getUuid(), reservation);

        return reservation.getUuid();
    }

    @Override
    public Optional<Reservation> findReservation(UUID uuid) {
       Reservation tmp = reservations.get(uuid);
       return Optional.ofNullable(tmp);

    }

    @Override
    public List<Reservation> findAllReservations() {
        return reservations.values().stream().collect(Collectors.toUnmodifiableList());
    }
}
