package com.example.ConcreteClass.gates;

import com.example.AbstractClass.ParkingSpotAbsCl;
import com.example.AbstractClass.VehicleAbsCl;
import com.example.ConcreteClass.tickets.Ticket;
import java.time.Duration;
import java.time.LocalDateTime;

public class ExitGate {
    public void removeVehicle(Ticket ticket) {
        ParkingSpotAbsCl spot = ticket.getParkingSpot();
        VehicleAbsCl vehicle = ticket.getVehicle();
        spot.removeVehicle();    
        System.out.println("Vehicle " + vehicle.getVehicleNo() + " removed from parking spot");
    }

    public float calculatePrice(Ticket ticket) {
        LocalDateTime exitTime = LocalDateTime.now();
        LocalDateTime entryTime = ticket.getEntryTime();
        ParkingSpotAbsCl spot = ticket.getParkingSpot();

        Duration duration = Duration.between(entryTime, exitTime);

        // Get the number of minutes between the two times
        long minutes = duration.toMinutes();

        return minutes*spot.getPrice();
    }
};