package com.example.ConcreteClass.gates;

import com.example.AbstractClass.ParkingSpotAbsCl;
import com.example.AbstractClass.ParkingSpotManager;
import com.example.AbstractClass.VehicleAbsCl;
import com.example.ConcreteClass.tickets.Ticket;

public class EntranceGate {

    public Ticket issueTicket(ParkingSpotManager PSManager, VehicleAbsCl vehicle) {
        ParkingSpotAbsCl pspot = PSManager.findParkingSpace();

        PSManager.parkVehicle(pspot, vehicle);
        Ticket ticket = new Ticket(vehicle, pspot);

        System.out.println("Issueing tiket for Vehicle Number: "+vehicle.getVehicleNo());
        return ticket;
    }
};