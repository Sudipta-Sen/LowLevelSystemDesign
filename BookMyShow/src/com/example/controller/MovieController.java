package com.example.controller;

import java.util.*;
import com.example.model.*;

public class MovieController {
    Map<City, List<Movie>> cityMovieList;
    public MovieController() {
        cityMovieList = new HashMap<>();
    }

    public void addNewCity(City city) {
        if(!cityMovieList.containsKey(city)) cityMovieList.put(city, new ArrayList<Movie>());
    }

    public boolean addMovie(City city, Movie movie) {
        if(!cityMovieList.containsKey(city)) return false;
        cityMovieList.get(city).add(movie);
        return true;
    }
}
