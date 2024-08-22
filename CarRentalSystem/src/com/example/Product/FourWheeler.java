package com.example.Product;

public class FourWheeler extends Vehicle {
    public FourWheeler(int vehicleID, String vehicleNumber, String model, int KmDriven, int dailyRentalCost, int monthlyRentalCost, int noOfSeat) {
        super(vehicleID, vehicleNumber, model, KmDriven, dailyRentalCost, monthlyRentalCost, noOfSeat, VehicleType.FOUR_WHEELER);
    }
}