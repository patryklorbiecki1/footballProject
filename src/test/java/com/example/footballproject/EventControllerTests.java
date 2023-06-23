package com.example.footballproject;

import com.example.footballproject.Entities.Event;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.maciejwalkowiak.wiremock.spring.ConfigureWireMock;
import com.maciejwalkowiak.wiremock.spring.EnableWireMock;
import com.maciejwalkowiak.wiremock.spring.InjectWireMock;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableWireMock({
        @ConfigureWireMock(name = "event-service", property = "event-service.url")
})
public class EventControllerTests {

    @Value("${filepath}")
    private String filepath;
    @InjectWireMock(value = "event-service")
    private WireMockServer eventService;
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void returnAllEvents() throws JsonProcessingException {
        eventService.stubFor(
                WireMock.get("/all")
                        .willReturn(aResponse()
                                .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                                .withBodyFile(filepath)));
        ResponseEntity<String> response = testRestTemplate.exchange(
                "http://localhost:8080/events/all",
                HttpMethod.GET,
                null,
                String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        Event[] events = objectMapper.readValue(response.getBody(), Event[].class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(events[0].getSeason_name()).isEqualTo("UEFA Champions League 21/22");
        /*
        todo
         */
    }
}
