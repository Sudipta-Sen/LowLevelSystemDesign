package com.example.model;

public class Movie {
    String name;
    String id;
    public Movie(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "name: "+name+", with id:"+id;
    }

}
