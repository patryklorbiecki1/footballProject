package com.example.footballproject.Services;

import com.example.footballproject.Entities.Event;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService {

    @Value("${filepath}")
    private String filepath;

    @Override
    public List<Event> getEventFromJSONFile(int number) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Event> events = mapper.readValue(new File(filepath), new TypeReference<List<Event>>() {
        });
        return events.stream()
                .sorted(Comparator
                        .comparingDouble(x ->
                                Math.min(x.getProbability_home_team_winner(),
                                        Math.min(x.getProbability_away_team_winner(), x.getProbability_draw()))))
                .limit(number)
                .collect(Collectors.toList());

    }
}
