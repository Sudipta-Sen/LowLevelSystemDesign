package com.example.ConcreteClass.tickets;

import com.example.AbstractClass.ParkingSpotAbsCl;
import com.example.AbstractClass.VehicleAbsCl;
import java.time.LocalDateTime;

public class Ticket {
    LocalDateTime entryTime;
    VehicleAbsCl vehicle;
    ParkingSpotAbsCl parkingSpot;

    public Ticket(VehicleAbsCl vehicle, ParkingSpotAbsCl parkingSpot) {
        this.entryTime = LocalDateTime.now();
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
    }

    public LocalDateTime getEntryTime() { return entryTime; }

    public ParkingSpotAbsCl getParkingSpot() { return parkingSpot; }

    public VehicleAbsCl getVehicle() { return vehicle; }

}