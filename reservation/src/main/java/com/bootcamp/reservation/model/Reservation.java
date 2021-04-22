package com.bootcamp.reservation.model;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Data
public class Reservation {
    @Setter (AccessLevel.PROTECTED)
    UUID uuid;
    UUID flightId;
    LocalDateTime reservationDateTime;
    TicketClass ticketClass;
    BigDecimal price;
    Passenger passenger;
}
