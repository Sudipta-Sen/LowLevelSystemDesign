package com.example.ConcreteClass.ParkingStrategies;

import com.example.AbstractClass.ParkingSpotAbsCl;
import com.example.AbstractClass.ParkingStrategy;
import java.util.*;

public class NearEntranceParking extends ParkingStrategy {
    @Override
    public ParkingSpotAbsCl findParkingSpot(List<ParkingSpotAbsCl> list) {
        ListIterator<ParkingSpotAbsCl> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            if(listIterator.previous().isSpotEmpty()) return listIterator.previous();
        }
        return null;
    }
};