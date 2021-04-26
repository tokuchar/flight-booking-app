package com.bootcamp.clientvalidator.api;

import com.bootcamp.clientvalidator.model.Client;
import com.bootcamp.clientvalidator.model.ValidationResponse;
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

    public boolean validate(Client client){
        return new ValidationResponse().isAdultValidation(client);
    }
}
