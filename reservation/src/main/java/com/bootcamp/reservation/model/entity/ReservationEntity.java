package com.bootcamp.reservation.model.entity;

import com.bootcamp.reservation.model.Passenger;
import com.bootcamp.reservation.model.Reservation;
import com.bootcamp.reservation.model.TicketClass;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservationEntity {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(
			name = "UUID",
			strategy = "org.hibernate.id.UUIDGenerator"
	)
	private UUID id;

	private UUID flightId;
	private LocalDateTime reservationDateTime;
	private TicketClass ticketClass;
	private BigDecimal price;

	@ManyToOne
	private PassengerEntity passenger;

	public static ReservationEntity map(Reservation reservation) {
		return ReservationEntity.builder()
				.id(reservation.getUuid())
				.flightId(reservation.getFlightId())
				.reservationDateTime(reservation.getReservationDateTime())
				.ticketClass(reservation.getTicketClass())
				.price(reservation.getPrice())
				.passenger(PassengerEntity.map(reservation.getPassenger()))
				.build();
	}
}
