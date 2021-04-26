package com.bootcamp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Client {
    private int id;
    private String name;
    private LocalDate birthDay;
    private boolean hasIDCard;
    private String country;
}
