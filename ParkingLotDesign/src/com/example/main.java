package com.example;

import com.example.AbstractClass.ParkingSpotManager;
import com.example.AbstractClass.VehicleAbsCl;
import com.example.ConcreteClass.ParkingStrategies.NearEntranceParking;
import com.example.ConcreteClass.ParkingStrategies.NearExitParking;
import com.example.ConcreteClass.gates.EntranceGate;
import com.example.ConcreteClass.gates.ExitGate;
import com.example.ConcreteClass.managers.FourWheelerManager;
import com.example.ConcreteClass.managers.TwoWheelerManager;
import com.example.ConcreteClass.spots.FourWheelerSpot;
import com.example.ConcreteClass.spots.TwoWheelerSpot;
import com.example.ConcreteClass.tickets.Ticket;
import com.example.ConcreteClass.vehicles.FourWheelerVehicle;
import com.example.ConcreteClass.vehicles.TwoWheelerVehicle;
import com.example.enums.VehicleType;
import java.util.*;


public class main {
    public static void main(String[] args) {

        ParkingSpotManager twoWheelerManager = new TwoWheelerManager(new ArrayList<>(), new NearEntranceParking());
        ParkingSpotManager fourWheelerManager = new FourWheelerManager(new ArrayList<>(), new NearExitParking());

        twoWheelerManager.addNewParkingSpace(new TwoWheelerSpot("Bike1"));
        twoWheelerManager.addNewParkingSpace(new TwoWheelerSpot("Cycle2"));

        fourWheelerManager.addNewParkingSpace(new FourWheelerSpot("Car1"));
        fourWheelerManager.addNewParkingSpace(new FourWheelerSpot("Car2"));

        EntranceGate entrance1 = new EntranceGate();
        ExitGate exit1 = new ExitGate();

        VehicleAbsCl vehicle1 = new TwoWheelerVehicle("AB1", VehicleType.TwoWheeler);
        VehicleAbsCl vehicle2 = new FourWheelerVehicle("AB2", VehicleType.FourWheeler);

        Ticket ticket1 = entrance1.issueTicket(twoWheelerManager, vehicle1);
        Ticket ticket2 = entrance1.issueTicket(fourWheelerManager, vehicle2);

        try {
            // Pause execution for 1 minute (60,000 milliseconds)
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            // Handle the exception if the thread is interrupted
            System.err.println("Thread was interrupted!");
            // e.printStackTrace();
        }

        System.out.println("Price for vehicle1 " + exit1.calculatePrice(ticket1));
        System.out.println("Price for vehicle2 "+ exit1.calculatePrice(ticket2));

        exit1.removeVehicle(ticket1);
        exit1.removeVehicle(ticket2);

    }
}

//del /S *.class
//javac com/example/enums/*.java com/example/AbstractClass/*.java com/example/ConcreteClass/*.java com/example/main.java
//java com.example.main
