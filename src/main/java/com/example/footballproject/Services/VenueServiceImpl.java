package com.example.footballproject.Services;

import com.example.footballproject.Entities.Competitor;
import com.example.footballproject.Entities.Ev;
import com.example.footballproject.Entities.Venue;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;


@Service
public class VenueServiceImpl implements VenueService{
    public Venue getVenueById(String id)
    {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
            Ev events = mapper.readValue(new File("./src/main/resources/data.json"), Ev.class);
            for(int i=0;i<events.getEvents().size();i++) {
                if(events.getEvents().get(i).getVenue().getId().equals(id))
                    return events.getEvents().get(i).getVenue();
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
