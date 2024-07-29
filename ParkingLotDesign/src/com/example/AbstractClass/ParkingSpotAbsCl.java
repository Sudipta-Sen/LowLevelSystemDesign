package com.example.AbstractClass;

public abstract class ParkingSpotAbsCl {
    String parkingSpotId;
    boolean isEmpty;
    VehicleAbsCl vehicle;
    int price;

    public ParkingSpotAbsCl(String parkingSpotId) {
        this.parkingSpotId = parkingSpotId;
        this.isEmpty = true;
        this.vehicle = null;
    }

    public String getparkingSpotID () { return parkingSpotId; }

    public boolean isSpotEmpty() { return isEmpty; }

    public abstract int getPrice();

    public void parkVehicle(VehicleAbsCl vehicle) {
        this.isEmpty = false;
        this.vehicle = vehicle;
    }

    public void removeVehicle() {
        this.isEmpty = true;
        this.vehicle = null;
    }

};