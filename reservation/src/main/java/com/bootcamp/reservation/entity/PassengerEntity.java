package com.bootcamp.reservation.entity;

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
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PassengerEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    UUID uuid;
    String name;
    String surname;

    public static PassengerEntity map(Passenger passenger) {
        return PassengerEntity.builder()
                .uuid(passenger.getUuid())
                .name(passenger.getName())
                .surname(passenger.getSurname())
                .build();
    }
}
