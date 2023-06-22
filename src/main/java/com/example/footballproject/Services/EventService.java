package com.example.footballproject.Services;

import com.example.footballproject.Entities.Event;

import java.io.IOException;
import java.util.List;

public interface EventService {
    List<Event> getEventFromJSONFile(int number) throws IOException;

}
