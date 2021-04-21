package com.bootcamp.reservation.model;

import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Value
public class Reservation {
    UUID uuid;
    UUID flightId;
    LocalDateTime reservationDateTime;
    TicketClass ticketClass;
    BigDecimal price;
    Passenger passenger;
}
