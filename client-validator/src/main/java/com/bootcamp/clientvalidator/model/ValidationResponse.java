package com.bootcamp.clientvalidator.model;

public class ValidationResponse {

    public boolean isAdultValidation(Client client){
        if(client.getAge()<18){
            return false;
        }
        return true;
    }

}
