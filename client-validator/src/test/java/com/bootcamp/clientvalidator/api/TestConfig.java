package com.bootcamp.clientvalidator.api;

import com.bootcamp.clientvalidator.model.ValidationResponse;
import com.bootcamp.clientvalidator.validator.MainValidator;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {

    @Bean
    ValidationResponse validationResponse() {
        return new ValidationResponse();
    }

    @Bean
    MainValidator validator() {
        return new MainValidator();
    }

}
