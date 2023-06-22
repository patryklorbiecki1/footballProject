package com.example.footballproject.Services;

import com.example.footballproject.Entities.Competitor;
import com.example.footballproject.Entities.Event;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

@Service
public class CompetitorServiceImpl implements CompetitorService {
    @Value("${filepath}")
    private String filepath;

    @Override
    public List<Competitor> getAllSortedCompetitors() throws IOException {
            ObjectMapper mapper = new ObjectMapper();
            List<Event> events = mapper.readValue(new File(filepath), new TypeReference<List<Event>>() {});
            return events.stream()
                    .flatMap(e->e.getCompetitors().stream())
                    .filter(distinctByKey(Competitor::getName))
                    .sorted(Comparator.comparing(Competitor::getName))
                    .toList();
    }

    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }
}
