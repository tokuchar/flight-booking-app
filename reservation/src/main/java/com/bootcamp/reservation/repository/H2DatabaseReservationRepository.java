package com.bootcamp.reservation.repository;

import com.bootcamp.reservation.entity.ReservationEntity;
import com.bootcamp.reservation.model.Reservation;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
public class H2DatabaseReservationRepository implements ReservationRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public UUID createReservation(Reservation reservation) {
        ModelMapper mapper = new ModelMapper();
        ReservationEntity reservationEntity = mapper.map(reservation, ReservationEntity.class);
        entityManager.persist(reservationEntity);
        return reservationEntity.getUuid();
    }

    @Override
    public Optional<Reservation> findReservation(UUID uuid) {
        ModelMapper mapper = new ModelMapper();
        Query query = entityManager.createQuery("select reservation from ReservationEntity reservation where reservation.uuid= :uuid");
        query.setParameter("uuid", uuid);
        Reservation reservation = mapper.map(query.getSingleResult(), Reservation.class);
        return Optional.of(reservation);
    }

    @Override
    public List<Reservation> findAllReservations() {
        Query query = entityManager.createQuery("select  reservation from ReservationEntity reservation");

        return new ArrayList<>(query.getResultList());
    }
}
