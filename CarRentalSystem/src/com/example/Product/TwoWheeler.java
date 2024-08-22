package com.example.Product;

public class TwoWheeler extends Vehicle {
    public TwoWheeler(int vehicleID, String vehicleNumber, String model, int KmDriven, int dailyRentalCost, int monthlyRentalCost, int noOfSeat) {
        super(vehicleID, vehicleNumber, model, KmDriven, dailyRentalCost, monthlyRentalCost, noOfSeat, VehicleType.TWO_WHEELER);
    }
}