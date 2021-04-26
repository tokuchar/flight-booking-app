package com.bootcamp.clientvalidator.api;

import com.bootcamp.clientvalidator.model.Client;
import com.bootcamp.clientvalidator.model.IdType;
import com.bootcamp.clientvalidator.model.ValidationResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest
class ValidatorApiTest {

    private Client client= new Client(18,true,"Polish", IdType.ID_CARD);
    @Autowired
    private MockMvc mvc;
    @Autowired
    private ObjectMapper objectMapper;


    @Test

    void isClientAdultTest() throws Exception {
        RequestBuilder requestBuilder= MockMvcRequestBuilders.get("/validator/isAdult")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(client))
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mvc.perform(requestBuilder).andReturn();

        ValidationResponse validationResponse = objectMapper.readValue(result.getResponse()
                .getContentAsString(),ValidationResponse.class);

    //    assertEquals(true,result.);
        assertTrue(validationResponse.isAdultValidation(client));
    }


}