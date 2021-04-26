package com.bootcamp.clientvalidator.api;

import com.bootcamp.clientvalidator.model.Client;
import com.bootcamp.clientvalidator.model.ValidationResponse;
import com.bootcamp.clientvalidator.validator.MainValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@RestController
@RequestMapping(path = "/validator")
public class ValidatorApi {
    @Autowired
    MainValidator validator;

    @PostMapping
    public String helloWorld() {
        return "hello";
    }

    @PostMapping("/age")
    public ValidationResponse validateAge(@RequestBody Client client){
        return validator.validateAge(client);
    }

    @PostMapping("/id")
    public ValidationResponse validateId(@RequestBody Client client){
        return validator.validateId(client);
    }

}
