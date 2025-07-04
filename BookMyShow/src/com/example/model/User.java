package com.example.model;

public class User {
    String id, name;
    City city;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public void updateCity(City city) {
        this.city = city;
    }

    public City getCity() {
        return city;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "id: "+id+", name: "+name+", city:"+city;
    }
}
