package com.example.footballproject.Services;

import com.example.footballproject.Entities.Competitor;
import com.example.footballproject.Entities.Ev;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class CompetitorServiceImpl implements CompetitorService {

    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }
    @Override
    public List<Competitor> getAllSortedCompetitors() {
        List<Competitor> competitors = new ArrayList<>();
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

            Ev events = mapper.readValue(new File("./src/main/resources/data.json"), Ev.class);
            for(int i=0;i<events.getEvents().size();i++) {
                competitors.add(events.getEvents().get(i).getCompetitors().get(0));
                competitors.add(events.getEvents().get(i).getCompetitors().get(1));
            }
            return competitors.stream().filter(distinctByKey(Competitor::getName)).sorted(Comparator.comparing(Competitor::getName)).collect(Collectors.toList());
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
