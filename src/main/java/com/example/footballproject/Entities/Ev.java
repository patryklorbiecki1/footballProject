package com.example.footballproject.Entities;


import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
public class Ev {
    private List<Event> events;

    public Ev(){

    }
}
