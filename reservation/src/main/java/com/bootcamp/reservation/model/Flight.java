package com.bootcamp.reservation.model;

import lombok.Value;

import java.util.UUID;

@Value
public class Flight {
     UUID uuid;
     String departureAirport;
     String arrivalAirport;
     int seats;
}
