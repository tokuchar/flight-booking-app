package com.bootcamp.reservation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
    UUID uuid;
    UUID flightId;
    LocalDateTime reservationDateTime;
    TicketClass ticketClass;
    BigDecimal price;
    Passenger passenger;

}
