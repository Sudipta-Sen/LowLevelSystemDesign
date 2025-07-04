package com.example.model;

import java.time.LocalDateTime;
import java.util.*;

public class Theater {
    String id, name;
    City city;
    List<Screen> screens;
    List<Show> shows;
    int noOfScreen;
    int noOfShow;

    public Theater(String id, String name, City city) {
        this.id = id;
        this.name = name;
        this.city = city;
        shows = new ArrayList<>();
        screens = new ArrayList<>();
        noOfScreen = 0;
        noOfShow = 0;
    }

    public Theater(Theater t) {
        id = t.id;
        name = t.name;
        city = t.city;
        screens = t.screens;
        shows = t.shows;
        noOfScreen = t.noOfScreen;
        noOfShow = t.noOfShow;
    }

    public Screen addScreen() {
        noOfScreen++;
        Screen screen = new Screen(id + "Sc-"+noOfScreen);
        screens.add(screen);
        return screen;
    }

    public void addShow(Screen screen, Movie movie, LocalDateTime starTime, LocalDateTime endTime) {
        noOfShow++;
        Show show = new Show(id+"_sh="+noOfShow, screen, movie, starTime, endTime);
        shows.add(show);
    }


    public List<Show> getAllShows() {
        return shows;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "id: "+id+", name:"+name+", city:"+city;
    }

}
