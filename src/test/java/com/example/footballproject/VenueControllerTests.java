package com.example.footballproject;

import com.example.footballproject.Entities.Venue;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.maciejwalkowiak.wiremock.spring.ConfigureWireMock;
import com.maciejwalkowiak.wiremock.spring.EnableWireMock;
import com.maciejwalkowiak.wiremock.spring.InjectWireMock;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableWireMock({
        @ConfigureWireMock(name = "venue-service", property = "venue-service.url")
})
public class VenueControllerTests {

    @InjectWireMock("venue-service")
    private WireMockServer venueService;
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void returnVenueById() {
        venueService.stubFor(
                WireMock.get("/sr:venue:8329")
                        .willReturn(aResponse()
                                .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                                .withBody("""
                                        {"id": "sr:venue:8329",
                                                 "name": "Elbasan Arena",
                                                 "capacity": 12500,
                                                 "city_name": "Elbasan",
                                                 "country_name": "Albania",
                                                 "map_coordinates": "41.115875,20.091992",
                                                 "country_code": "ALB"}
                                        """)));
        ResponseEntity<Venue> response = testRestTemplate.getForEntity("http://localhost:8080/venue/sr:venue:8329", Venue.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getId()).isEqualTo("sr:venue:8329");
        assertThat(response.getBody().getName()).isEqualTo("Elbasan Arena");
        assertThat(response.getBody().getCapacity()).isEqualTo("12500");
        assertThat(response.getBody().getCity_name()).isEqualTo("Elbasan");
        assertThat(response.getBody().getCountry_name()).isEqualTo("Albania");
        assertThat(response.getBody().getMap_coordinates()).isEqualTo("41.115875,20.091992");
        assertThat(response.getBody().getCountry_code()).isEqualTo("ALB");

    }
}
