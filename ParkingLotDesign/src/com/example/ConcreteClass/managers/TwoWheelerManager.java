package com.example.ConcreteClass.managers;

import java.util.*;
import com.example.AbstractClass.ParkingSpotManager;
import com.example.AbstractClass.ParkingSpotAbsCl;
import com.example.AbstractClass.ParkingStrategy;

public class TwoWheelerManager extends ParkingSpotManager {
    public TwoWheelerManager(List<ParkingSpotAbsCl> list, ParkingStrategy pstat) {
        super(list, pstat);
    }
};