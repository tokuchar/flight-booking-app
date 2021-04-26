package com.bootcamp.clientvalidator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

@AllArgsConstructor
@Data
public class Client {
    private int age;
    private boolean isAdult;
    private String nationality;
    private IdType idType;

}
