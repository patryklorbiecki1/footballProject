package com.example.footballproject.Services;

import com.example.footballproject.Entities.Ev;
import com.example.footballproject.Entities.Event;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService{

    @Override
    public List<Event> getEventFromJSONFile(int number) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

            Ev events = mapper.readValue(new File("./src/main/resources/data.json"), Ev.class);
            return events.getEvents().stream().sorted(Comparator
                    .comparingDouble(x->Math.min(x.getProbability_home_team_winner(),
                            Math.min(x.getProbability_away_team_winner(),x.getProbability_draw())))).limit(number).collect(Collectors.toList());

        } catch (
                IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
