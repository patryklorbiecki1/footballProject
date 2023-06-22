package com.example.footballproject.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Venue {
    private String id;
    private String name;
    private String capacity;
    private String city_name;
    private String country_name;
    private String map_coordinates;
    private String country_code;

    public Venue() {
    }
}
