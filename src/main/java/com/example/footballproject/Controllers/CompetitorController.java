package com.example.footballproject.Controllers;

import com.example.footballproject.Entities.Competitor;
import com.example.footballproject.Services.CompetitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/competitor")
public class CompetitorController {
    private final CompetitorService competitorService;

    @Autowired
    public CompetitorController(CompetitorService competitorService) {
        this.competitorService = competitorService;
    }

    @GetMapping("all")
    public List<Competitor> getAll() throws IOException {
        return competitorService.getAllSortedCompetitors();
    }

}
