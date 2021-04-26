package com.bootcamp.clientvalidator.logic;

import com.bootcamp.model.Client;

import java.time.LocalDate;
import java.time.Period;

public class InputValidator {
    public boolean isOver18(Client client) {
        Period period = Period.between(client.getBirthDay(), LocalDate.now());
        return period.getYears() >= 18;
    }
}
