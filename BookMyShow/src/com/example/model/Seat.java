package com.example.model;

public class Seat {
    int row, col;
    SeatCategory seatCategory;
    volatile boolean isBooked;
    public Seat(int row, int col, SeatCategory seatCategory) {
        this.row = row;
        this.col = col;
        this.seatCategory = seatCategory;
        isBooked = false; // volatile to guarantee visibility across threads
    }

    public boolean isSeatBooked() {
        return isBooked;
    }
    public boolean bookSeat() {
        if(isBooked==true) return false;
        isBooked=true;
        return true; 
    }

    @Override
    public String toString() {
        return "row: "+row+", col: "+col+", with category: "+seatCategory;
    }
}
