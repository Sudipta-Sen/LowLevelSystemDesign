package com.example.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.model.Theater;
import com.example.model.City;

public class TheaterController {
    HashMap<City, List<Theater>> cityTheaterList;
    List<Theater> allTheaters;

    public TheaterController() {
        cityTheaterList = new HashMap<>();
        allTheaters = new ArrayList<>();
    }

    public void addCity(City city) {
        if(!cityTheaterList.containsKey(city)) cityTheaterList.put(city, new ArrayList<>());
    }

    public void addTheater(City city, Theater theater) {
        if(!allTheaters.contains(theater)) {
            cityTheaterList.get(city).add(theater);
            allTheaters.add(theater);
        }
    }

    public List<Theater> getAllTheaters(City city) {
        List<Theater> theaters = new ArrayList<>();
        for (Theater t: cityTheaterList.get(city)) {
            theaters.add(new Theater(t));
        }
        return theaters;
    }
}
