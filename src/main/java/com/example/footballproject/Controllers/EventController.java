package com.example.footballproject.Controllers;

import com.example.footballproject.Entities.Event;
import com.example.footballproject.Services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/events")
public class EventController {
    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("all")
    public List<Event> getAll() throws IOException {
        return eventService.getEventFromJSONFile(10);
    }

    @GetMapping("{number}")
    public List<Event> getAll(@PathVariable int number) throws IOException {
        return eventService.getEventFromJSONFile(number);
    }


}
