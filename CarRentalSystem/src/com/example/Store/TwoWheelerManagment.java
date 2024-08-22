package com.example.Store;

import com.example.Product.Vehicle;
import com.example.Product.VehicleType;

public class TwoWheelerManagment extends VehicleInventoryManagment {

    @Override
    public boolean vehicleCheck(Vehicle vh) {
        return vh.getType()==VehicleType.TWO_WHEELER;
    }
    
}