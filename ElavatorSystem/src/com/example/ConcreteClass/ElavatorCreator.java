package com.example.ConcreteClass;

import java.util.*;

public class ElavatorCreator{
    static List<ElavatorController> elavatorControllers = new ArrayList<>();
    static List<ElavatorCar> elavatorCars = new ArrayList<>();

    public ElavatorCreator(int numberOfElavators) {
        for(int i=0; i<numberOfElavators; i++) {
            elavatorCars.add(new ElavatorCar(i+1));
            elavatorControllers.add(new ElavatorController(elavatorCars.get(i)));
        }
    }

    public static List<ElavatorController> getElavatorController() {
        if(elavatorControllers==null) {
            System.out.println("elavator controller list is null");
            System.exit(0);
        }
        return elavatorControllers;
    }

    public static List<ElavatorCar> getElavatorCars() {
        return elavatorCars;
    }
}