package com.example.Store;

import com.example.Product.Vehicle;
import java.util.*;

public abstract class VehicleInventoryManagment {
    List<Vehicle> vehicleList;

    public VehicleInventoryManagment() {
        vehicleList = new ArrayList<>();
    }

    public abstract boolean vehicleCheck(Vehicle vh);

    public void addVehicle(Vehicle vh) {
        if(vehicleCheck(vh)) vehicleList.add(vh);
        else System.out.println("Vehicle Type is not correct");
    }

    public void removeVehicle(Vehicle vh) {
        vehicleList.remove(vh);
    }
}