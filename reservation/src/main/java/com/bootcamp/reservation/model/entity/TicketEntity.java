package com.bootcamp.reservation.model.entity;

import com.bootcamp.reservation.model.TicketClass;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketEntity {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(
			name = "UUID",
			strategy = "org.hibernate.id.UUIDGenerator"
	)
	private UUID id;

	@Enumerated(EnumType.STRING)
	private TicketClass ticketClass;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private PassengerEntity passenger;

}
