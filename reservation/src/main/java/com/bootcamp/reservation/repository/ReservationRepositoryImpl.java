package com.bootcamp.reservation.repository;

import com.bootcamp.reservation.model.Reservation;
import com.bootcamp.reservation.model.entity.ReservationEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Transactional
@Repository
@Qualifier("ReservationRepositoryImpl")
public class ReservationRepositoryImpl implements ReservationRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public UUID createReservation(Reservation reservation) {
		ReservationEntity reservationEntity = ReservationEntity.map(reservation);
		entityManager.persist(reservationEntity);
		return reservationEntity.getId();
	}

	@Override
	public Optional<Reservation> findReservation(UUID uuid) {
		Reservation reservation = entityManager.find(Reservation.class, uuid);
		return Optional.ofNullable(reservation);
	}

	@Override
	public List<Reservation> findAllReservations() {
		return null;
	}

}
