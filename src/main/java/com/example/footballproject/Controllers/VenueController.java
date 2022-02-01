package com.example.footballproject.Controllers;

import com.example.footballproject.Entities.Venue;
import com.example.footballproject.Services.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/venue")
public class VenueController {
    private final VenueService venueService;
    @Autowired
    public VenueController(VenueService venueService)
    {
        this.venueService = venueService;
    }
    @GetMapping("{id}")
    public ResponseEntity<Venue> getVeneById(@PathVariable String id){
        return new ResponseEntity<>(venueService.getVenueById(id), HttpStatus.OK);
    }
}
