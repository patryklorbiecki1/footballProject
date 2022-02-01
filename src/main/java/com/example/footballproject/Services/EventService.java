package com.example.footballproject.Services;

import com.example.footballproject.Entities.Event;

import java.util.List;

public interface EventService {
    List<Event> getEventFromJSONFile(int number);

}
