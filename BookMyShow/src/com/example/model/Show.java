package com.example.model;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.locks.StampedLock;
public class Show {
    String id;
    Screen screen;
    Movie movie;
    LocalDateTime startTime, endTime;
    ArrayList<Seat> bookedSeats;
    private final StampedLock lock = new StampedLock();
    
    public Show(String id, Screen screen, Movie movie, LocalDateTime starTime, LocalDateTime endTime) {
        this.id = id;
        this.screen = screen;
        this.movie = movie;
        this.startTime = starTime;
        this.endTime = endTime;
        this.bookedSeats = new ArrayList<>();
    }

    public List<Seat> getAllSeats() {
        return screen.getAllSeats();
    }

    public boolean bookSeat(Seat seat) throws InterruptedException {
        
        long stamp = lock.tryOptimisticRead();
        boolean curStatus = seat.isBooked;
        if (!lock.validate(stamp)) {
                // Optimistic read failed, upgrade to read lock
                stamp = lock.readLock();
                try {
                    curStatus = seat.isBooked;
                } finally {
                    lock.unlockRead(stamp);
                }
            }

            if (curStatus) {
                stamp = lock.writeLock(); // acquire write lock to book
                try {
                    if (seat.isBooked==false) {
                        Thread.sleep(50); // simulate booking
                        seat.isBooked = true;
                        return true;
                    }
                } finally {
                    lock.unlockWrite(stamp);
                }
            }
        return false;
    }

    @Override
    public String toString() {
        return "show id: "+id+", screen: "+screen+", movie: "+movie;
    }
}
