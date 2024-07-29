package com.example.AbstractClass;

import java.util.*; 

public abstract class ParkingSpotManager{
    List<ParkingSpotAbsCl> spotlist;
    ParkingStrategy pStragy;

    public ParkingSpotManager(List<ParkingSpotAbsCl> list, ParkingStrategy pst) {
        this.spotlist = list;
        this.pStragy = pst;
    }

    public void addNewParkingSpace(ParkingSpotAbsCl spot) {
        this.spotlist.add(spot);
    }

    public void removeParkingSpace(ParkingSpotAbsCl spot) {
        this.spotlist.remove(spot);
    }

    public void parkVehicle(ParkingSpotAbsCl spot, VehicleAbsCl vehicle) {
        spot.parkVehicle(vehicle);
    }

    public void removeVehicle(ParkingSpotAbsCl spot) {
        spot.removeVehicle();
    }

    public ParkingSpotAbsCl findParkingSpace() {
        return pStragy.findParkingSpot(spotlist);
    }

};