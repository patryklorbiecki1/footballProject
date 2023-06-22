package com.example.footballproject.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Competitor {
    private String id;
    private String name;
    private String country;
    private String country_code;
    private String abbreviation;
    private String qualifier;
    private String gender;

    public Competitor() {

    }
}
