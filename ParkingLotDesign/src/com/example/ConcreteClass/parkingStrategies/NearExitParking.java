package com.example.ConcreteClass.ParkingStrategies;

import java.util.*;
import com.example.AbstractClass.ParkingStrategy;
import com.example.AbstractClass.ParkingSpotAbsCl;

public class NearExitParking extends ParkingStrategy {
    @Override
    public ParkingSpotAbsCl findParkingSpot(List<ParkingSpotAbsCl> list) {
        for (ParkingSpotAbsCl spot: list) {
            if (spot.isSpotEmpty()) return spot;
        }
        return null;
    }
};