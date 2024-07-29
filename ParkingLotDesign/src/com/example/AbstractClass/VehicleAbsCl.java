package com.example.AbstractClass;

import com.example.enums.VehicleType;

public abstract class VehicleAbsCl{
    String vehicleNo;
    VehicleType vehicleType;

    public VehicleAbsCl(String vehicleNo, VehicleType vType) {
        this.vehicleNo = vehicleNo;
        this.vehicleType = vType;
    }

    public String getVehicleNo() { return vehicleNo; }

    public VehicleType getVehicleType() { return vehicleType; }   
};