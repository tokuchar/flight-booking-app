package com.bootcamp.reservation.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@EnableSwagger2
@RequestMapping(path = "/reservation")
public class ReservationApi {

    @GetMapping
    public String helloWorld(){
        return "hello";
    }
}
