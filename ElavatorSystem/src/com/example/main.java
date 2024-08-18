package com.example;

import com.example.ConcreteClass.ElavatorCar;
import com.example.ConcreteClass.ElavatorController;
import com.example.ConcreteClass.ElavatorCreator;
import com.example.ConcreteClass.Floor;
import com.example.ConcreteClass.NearestExternalDispatcher;
import java.util.*;

public class main {
    public static void main(String[] args) {
        List<Floor> floors = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            floors.add(new Floor(i));
            floors.get(i).setExternalButton(new NearestExternalDispatcher());
        }
        ElavatorCreator elavatorCreator = new ElavatorCreator(3);
        List<ElavatorController> controllers = ElavatorCreator.getElavatorController();
        List<ElavatorCar> elavatorCars = ElavatorCreator.getElavatorCars();
        floors.get(3).pressDownButton();
        elavatorCars.get(1).pressButton(8);
        elavatorCars.get(2).pressButton(6);
        elavatorCars.get(2).pressButton(3);
        floors.get(1).pressUpButton();

        

        for(ElavatorController controller:controllers) {
            controller.controlElavatorCar();
        }

        elavatorCars.get(2).pressButton(0);

        for(ElavatorController controller:controllers) {
            controller.controlElavatorCar();
        }

    }
}