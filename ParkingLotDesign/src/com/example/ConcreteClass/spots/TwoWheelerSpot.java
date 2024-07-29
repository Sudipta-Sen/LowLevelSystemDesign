package com.example.ConcreteClass.spots;

import com.example.AbstractClass.ParkingSpotAbsCl;

public class TwoWheelerSpot extends ParkingSpotAbsCl{
    public TwoWheelerSpot(String parkingSpotId) {
        super(parkingSpotId);
    }

    @Override
    public int getPrice() { return 20; }
};