package com.example.footballproject.Controllers;

import com.example.footballproject.Entities.Venue;
import com.example.footballproject.Services.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/venue")
public class VenueController {
    private final VenueService venueService;

    @Autowired
    public VenueController(VenueService venueService) {
        this.venueService = venueService;
    }

    @GetMapping("{id}")
    public Optional<Venue> getVeneById(@PathVariable String id) throws IOException {
        return venueService.getVenueById(id);
    }
}
