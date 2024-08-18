package com.example.ConcreteClass;

import java.util.*;

public class InternalButtonDispatcher {
    List<ElavatorController> elavatorControllers;

    public InternalButtonDispatcher() {
        elavatorControllers = ElavatorCreator.getElavatorController();
    }

    public void submitRequest(int destination, ElavatorCar elavatorCar) {
        for(ElavatorController controller:elavatorControllers) {
            if(controller.getElavatorId() == elavatorCar.elavatorId) {
                controller.acceptInternalRequest(destination);
            }
        }
    }
}