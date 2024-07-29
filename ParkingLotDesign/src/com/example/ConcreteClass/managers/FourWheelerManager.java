package com.example.ConcreteClass.managers;

import com.example.AbstractClass.ParkingSpotAbsCl;
import java.util.*;
import com.example.AbstractClass.ParkingSpotManager;
import com.example.AbstractClass.ParkingStrategy;

public class FourWheelerManager extends ParkingSpotManager {
    public FourWheelerManager(List<ParkingSpotAbsCl> list, ParkingStrategy pst) {
        super(list, pst);
    }
};