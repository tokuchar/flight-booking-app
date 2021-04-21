package com.bootcamp.reservation.model;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Data
public class Reservation {
    @Setter (AccessLevel.PROTECTED)
    private UUID uuid;
    @Setter (AccessLevel.PROTECTED)
    private UUID flightId;
    @Setter (AccessLevel.PROTECTED)
    private LocalDateTime reservationDateTime;
    @Setter (AccessLevel.PROTECTED)
    private TicketClass ticketClass;
    @Setter (AccessLevel.PROTECTED)
    private BigDecimal price;
    @Setter (AccessLevel.PROTECTED)
    private Passenger passenger;
}
