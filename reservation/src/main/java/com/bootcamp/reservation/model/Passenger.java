package com.bootcamp.reservation.model;

import lombok.Value;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Value
public class Passenger {
    UUID uuid;
    String name;
    String surname;
}
