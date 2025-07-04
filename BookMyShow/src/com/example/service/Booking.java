package com.example.service;

import com.example.model.*;

public class Booking {
    Show show;
    Seat seat;
    City city;
    Theater theater;
    User user;

    public Booking(User user, Show show, Seat seat, City city, Theater theater) {
        this.user = user;
        this.show = show;
        this.seat = seat;
        this.city = city;
        this.theater = theater;
    }

    @Override
    public String toString() {
        return "Booking Details:\n" +
            "\tUser: \n\t\t" + user + "\n" +
            "\tCity: \n\t\t" + city + "\n" +
            "\tTheater: \n\t\t" + theater.getId() + "\n" +
            "\tShow: \n\t\t" + show + "\n" +
            "\tSeat: \n\t\t" + seat + ")";
    }
}
