package com.bootcamp.reservation.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
    UUID uuid;
    Flight flight;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime reservationDateTime;
    TicketClass ticketClass;
    BigDecimal price;
    Passenger passenger;
}
