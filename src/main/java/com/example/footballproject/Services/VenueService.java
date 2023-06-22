package com.example.footballproject.Services;

import com.example.footballproject.Entities.Venue;

import java.io.IOException;
import java.util.Optional;

public interface VenueService {
    Optional<Venue> getVenueById(String id) throws IOException;
}
