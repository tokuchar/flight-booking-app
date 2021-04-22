package com.bootcamp.reservation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationEntity {
    @Id
    UUID uuid;
    @Transient
    UUID flightId;
    @Column
    LocalDateTime reservationDateTime;
    @Enumerated(EnumType.STRING)
    TicketClass ticketClass;
    @Column
    BigDecimal price;
    @ManyToOne
    Passenger passenger;

}
