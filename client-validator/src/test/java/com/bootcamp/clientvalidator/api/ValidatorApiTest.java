package com.bootcamp.clientvalidator.api;

import com.bootcamp.clientvalidator.model.Client;
import com.bootcamp.clientvalidator.model.ValidationResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;


@WebMvcTest(ValidatorApi.class)
@Import(TestConfig.class)
class ValidatorApiTest {
    @Autowired
    private MockMvc mvc;
    @Autowired
    private ObjectMapper objectMapper;

    private Client client = Client.builder()
            .name("Tomek")
            .surname("Kowalski")
            .age(18)
            .nationality("Polish")
            .build();

    private Client notAdultClient = Client.builder()
            .name("Tomek")
            .surname("Kowalski")
            .age(16)
            .nationality("English")
            .build();

    @Test
    void testHelloWorld() throws Exception {
        // given & when
        RequestBuilder request = MockMvcRequestBuilders.get("/validator");
        MvcResult result = mvc.perform(request)
                .andReturn();

        // then
        assertEquals("hello", result.getResponse().getContentAsString());
    }

    @Test
    void validationTest() throws Exception {

        RequestBuilder request = MockMvcRequestBuilders.post("/validator")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(client))
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mvc.perform(request)
                .andReturn();

        ValidationResponse validationResponse = objectMapper.readValue(result.getResponse().getContentAsString(),ValidationResponse.class);
    }

    @Test
    void shouldVerifyIsClientAdult() throws Exception {
       RequestBuilder request = MockMvcRequestBuilders.post("/validator/age")
               .contentType(MediaType.APPLICATION_JSON)
               .content(objectMapper.writeValueAsString(client))
               .accept(MediaType.APPLICATION_JSON);

       MvcResult result = mvc.perform(request)
               .andReturn();

       ValidationResponse validationResponse = objectMapper.readValue(result.getResponse().getContentAsString(), ValidationResponse.class);
       ValidationResponse expectedResponse = new ValidationResponse("", true);

        Assertions.assertEquals(validationResponse, expectedResponse);
    }
    @Test
    void shouldVerifyIsClientNotAdult() throws Exception{
        RequestBuilder request = MockMvcRequestBuilders.post("/validator")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(notAdultClient))
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mvc.perform(request)
                .andReturn();

        ValidationResponse validationResponse = objectMapper.readValue(result.getResponse().getContentAsString(), ValidationResponse.class);
        ValidationResponse expectedResponse = new ValidationResponse("", false);
        Assertions.assertEquals(validationResponse, expectedResponse);
    }

    @Test
    void shouldVerifyIfClientHasIdCard() throws Exception{
        RequestBuilder request = MockMvcRequestBuilders.post("/validator/id")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(client))
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mvc.perform(request)
                .andReturn();

        ValidationResponse validationResponse = objectMapper.readValue(result.getResponse().getContentAsString(), ValidationResponse.class);
        ValidationResponse expectedResponse = new ValidationResponse("", true);
        Assertions.assertEquals(validationResponse, expectedResponse);
    }

    @Test
    void shouldVerifyIfClientHasntGotIdCard() throws Exception{
        RequestBuilder request = MockMvcRequestBuilders.post("/validator/id")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(notAdultClient))
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mvc.perform(request)
                .andReturn();

        ValidationResponse validationResponse = objectMapper.readValue(result.getResponse().getContentAsString(), ValidationResponse.class);
        ValidationResponse expectedResponse = new ValidationResponse("", false);
        Assertions.assertEquals(validationResponse, expectedResponse);
    }
}