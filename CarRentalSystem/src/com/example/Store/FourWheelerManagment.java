package com.example.Store;

import com.example.Product.Vehicle;
import com.example.Product.VehicleType;

public class FourWheelerManagment extends VehicleInventoryManagment {

    @Override
    public boolean vehicleCheck(Vehicle vh) {
        return vh.getType()==VehicleType.FOUR_WHEELER;
    }
    
}