package com.example.model;

import java.util.*;

public class Screen {
    String id;
    List<Seat> seats;
    int curRow, curCol;
    public Screen(String id) {
        this.id = id;
        seats = new ArrayList<>();
        curRow=curCol=1;
    }

    public void addSeats(SeatCategory seatCategory, int no_of_seat) {
        for(int i=0; i<no_of_seat; i++) {
            Seat seat = new Seat(curRow, curCol++, seatCategory);
            if(curCol==5) {
                curRow++;
                curCol=1;
            }
            seats.add(seat);
        }
    }

    public List<Seat> getAllSeats() {
        return seats;
    }

    @Override
    public String toString() {
        return id;
    }
}
