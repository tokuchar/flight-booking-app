package com.bootcamp.reservation.model;

import lombok.Value;

import java.util.UUID;

@Value
public class Passenger {
    UUID uuid;
    String name;
    String surname;
}
