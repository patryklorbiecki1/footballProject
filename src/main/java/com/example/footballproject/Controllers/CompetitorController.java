package com.example.footballproject.Controllers;

import com.example.footballproject.Entities.Competitor;
import com.example.footballproject.Services.CompetitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/competitor")
public class CompetitorController {
    private final CompetitorService competitorService;
    @Autowired
    public CompetitorController(CompetitorService competitorService)
    {
        this.competitorService = competitorService;
    }
    @GetMapping("all")
    public ResponseEntity<List<Competitor>> getAll(){
        return new ResponseEntity<>(competitorService.getAllSortedCompetitors(), HttpStatus.OK);
    }

}
