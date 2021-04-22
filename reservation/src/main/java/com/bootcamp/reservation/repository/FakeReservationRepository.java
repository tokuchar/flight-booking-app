package com.bootcamp.reservation.repository;

import com.bootcamp.reservation.model.Passenger;
import com.bootcamp.reservation.model.Reservation;
import com.bootcamp.reservation.model.ReservationEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.*;

@Repository
@Transactional
public class FakeReservationRepository implements ReservationRepository{
    private static final Map<UUID, ReservationEntity> reservations = new HashMap<>();

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public UUID createReservation(ReservationEntity reservation) {
        UUID id = UUID.randomUUID();
        reservation.setUuid(id);
        entityManager.persist(reservation);
        reservations.put(id, reservation);
        return id;
    }

    @Override
    public Optional<ReservationEntity> findReservation(UUID uuid) {
        entityManager.find(Reservation.class, uuid);
        return Optional.ofNullable(reservations.get(uuid));
    }

    @Override
    public List<ReservationEntity> findAllReservations() {
        entityManager.createQuery("SELECT reservation from ReservationEntity reservation");
        return new ArrayList(reservations.values());
    }


}
