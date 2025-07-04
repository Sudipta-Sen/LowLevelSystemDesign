package com.example.model;

public class City {
    String name;
    String state;
    String id;
    public City(String name, String state, String id) {
        this.name = name;
        this.state = state;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getState() {
        return state;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "name: "+name+", state: "+state+", id:"+id;
    }
}
