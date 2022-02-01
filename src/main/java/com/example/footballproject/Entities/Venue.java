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
    public Venue(){}
//     "id": "sr:venue:8329",
//                "name": "Elbasan Arena",
//                "capacity": 12500,
//                "city_name": "Elbasan",
//                "country_name": "Albania",
//                "map_coordinates": "41.115875,20.091992",
//                "country_code": "ALB"
}
