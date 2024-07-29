package com.example.ConcreteClass.spots;

import com.example.AbstractClass.ParkingSpotAbsCl;

public class FourWheelerSpot extends ParkingSpotAbsCl {
    public FourWheelerSpot(String parkingSpotId) {
        super(parkingSpotId);
    }

    @Override
    public int getPrice() { return 50; }
};