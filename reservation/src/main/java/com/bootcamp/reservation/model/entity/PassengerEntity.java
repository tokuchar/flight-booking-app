package com.bootcamp.reservation.model.entity;

import com.bootcamp.reservation.model.Passenger;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PassengerEntity {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(
			name = "UUID",
			strategy = "org.hibernate.id.UUIDGenerator"
	)
	private UUID id;

	@Column(nullable = false)
	String name;

	@Column(nullable = false)
	String surname;

	public PassengerEntity build(Passenger passenger) {
		return PassengerEntity.builder()
				.id(passenger.getUuid())
				.name(passenger.getName())
				.surname(passenger.getSurname())
				.build();
	}

}
