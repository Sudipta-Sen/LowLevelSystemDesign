package com.example.Product;

public abstract class Vehicle {
    int vehicleID;
    String vehicleNumber;
    String model;
    int KmDriven;
    int dailyRentalCost;
    int monthlyRentalCost;
    int noOfSeat;
    VehicleType vType;
    VehicleStatus vStatus;

    public Vehicle(int vehicleID, String vehicleNumber, String model, int KmDriven, int dailyRentalCost, int monthlyRentalCost, int noOfSeat, VehicleType vType) {
        this.vehicleID = vehicleID;
        this.vehicleNumber = vehicleNumber;
        this.model = model;
        this.KmDriven = KmDriven;
        this.dailyRentalCost = dailyRentalCost;
        this.monthlyRentalCost = monthlyRentalCost;
        this.noOfSeat = noOfSeat;
        this.vType = vType;
        this.vStatus = VehicleStatus.ACTIVE;
    }

    public VehicleType getType() {
        return vType;
    }

    public void updateStatus(VehicleStatus vStatus) {
        this.vStatus = vStatus;
    }

};