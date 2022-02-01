package com.example.footballproject.Controllers;

import com.example.footballproject.Entities.Event;
import com.example.footballproject.Services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/events")
public class EventController {
    private final EventService eventService;
    @Autowired
    public EventController(EventService eventService)
    {
        this.eventService = eventService;
    }
    @GetMapping("all")
    public ResponseEntity<List<Event>> getAll(){
        return new ResponseEntity<>(eventService.getEventFromJSONFile(10), HttpStatus.OK);
    }

    @GetMapping("{number}")
    public ResponseEntity<List<Event>> getAll(@PathVariable int number){
        return new ResponseEntity<>(eventService.getEventFromJSONFile(number), HttpStatus.OK);
    }


}
