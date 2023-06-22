package com.example.footballproject.Services;

import com.example.footballproject.Entities.Event;
import com.example.footballproject.Entities.Venue;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;


@Service
public class VenueServiceImpl implements VenueService {
    @Value("${filepath}")
    private String filepath;

    public Optional<Venue> getVenueById(String id) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        List<Event> events = mapper.readValue(new File(filepath), new TypeReference<List<Event>>() {
        });
        return events.stream()
                .map(Event::getVenue)
                .filter(venue -> venue.getId().equals(id))
                .findFirst();
    }
}
