package com.bootcamp.clientvalidator.api;

import com.bootcamp.model.Client;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.time.Period;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ValidatorApi.class)
class ValidatorApiTest {

    @Autowired
    private MockMvc mvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    ValidatorApi validatorApi;

    @Test
    void ofAge() throws Exception{
        Client client = Client.builder()
                .name("Piotrek")
                .id(1)
                .hasIDCard(true)
                .country("Poland")
                .birthDay(LocalDate.of(1994, 10, 15))
                .build();
        RequestBuilder request = post("/validator")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(client))
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = (MvcResult) mvc.perform(
                post("/validator")
                        .contentType(MediaType.APPLICATION_JSON)
                        .contentType(objectMapper.writeValueAsString(client))
        ).andExpect(status().isOk()
        );
    }

}