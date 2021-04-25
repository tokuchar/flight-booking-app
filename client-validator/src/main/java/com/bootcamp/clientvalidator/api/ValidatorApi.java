package com.bootcamp.clientvalidator.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@RestController
@RequestMapping(path = "/validator")
public class ValidatorApi {
    @PostMapping
    public String helloWorld() {
        return "hello";
    }
}
