package com.example.footballproject.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Event {
    private String sport_event_id;
    private String start_date;
    private String sport_name;
    private String competition_name;
    private String competition_id;
    private String season_name;
    private List<Competitor> competitors;
    private Venue venue;
    private float probability_home_team_winner;
    private float probability_draw;
    private float probability_away_team_winner;

    public Event() {

    }
}
