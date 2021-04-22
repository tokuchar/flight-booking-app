package com.bootcamp.reservation.repository;

import com.bootcamp.reservation.model.Reservation;
import com.bootcamp.reservation.model.entity.ReservationEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@Qualifier("ReservationRepositoryImpl")
public class ReservationRepositoryImpl implements ReservationRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public UUID createReservation(Reservation reservation) {
		UUID id = UUID.randomUUID();
		entityManager.createNativeQuery("INSERT INTO reservation_entity (id, flightId, reservationDateTime, ticketClass, price, passenger) VALUES (?, ?, ?, ?, ?, ?)")
				.setParameter(1, id)
				.setParameter(2, reservation.getFlightId())
				.setParameter(3, reservation.getReservationDateTime())
				.setParameter(4, reservation.getTicketClass())
				.setParameter(5, reservation.getPrice())
				.setParameter(6, reservation.getPassenger())
				.executeUpdate();
		return id;
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
