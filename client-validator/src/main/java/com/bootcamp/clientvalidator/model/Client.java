package com.bootcamp.clientvalidator.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class Client {
    String name;
    String surname;
    int age;
    String nationality;
}
