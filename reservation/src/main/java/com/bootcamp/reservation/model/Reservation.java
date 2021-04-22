package com.bootcamp.reservation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
    private UUID uuid;
    private UUID flightId;
    private LocalDateTime reservationDateTime;
    private TicketClass ticketClass;
    private BigDecimal price;
    private Passenger passenger;
}
