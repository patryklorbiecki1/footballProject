package com.example.footballproject.Services;

import com.example.footballproject.Entities.Competitor;

import java.io.IOException;
import java.util.List;

public interface CompetitorService {
    List<Competitor> getAllSortedCompetitors() throws IOException;
}
