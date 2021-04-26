package com.bootcamp.clientvalidator.validator;

import com.bootcamp.clientvalidator.model.Client;
import com.bootcamp.clientvalidator.model.ValidationResponse;
import org.springframework.stereotype.Component;

@Component
public class MainValidator {
    int age;
    String nationality;

    public ValidationResponse validateAge(Client client) {
        String message = null;
        boolean isAdult = false;
        return new ValidationResponse(message,isAdult);
    }
    public ValidationResponse validateId(Client client){
        String message = null;
        boolean isAdult = false;
        return new ValidationResponse(message,isAdult);
    }

}
