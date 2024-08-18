package com.example.ConcreteClass;

import com.example.Interface.ExternalButtonDispatcher;
import com.example.enums.ElavatorDirection;
import java.util.*;

public class NearestExternalDispatcher implements ExternalButtonDispatcher {
    List<ElavatorController> elavatorControllers;

    public NearestExternalDispatcher() {
        elavatorControllers = ElavatorCreator.getElavatorController();
    }

    @Override
    public void submitRequest(Floor dstFloor, ElavatorDirection dir) {
        ElavatorController nearest = elavatorControllers.get(0);
        int minDistance = Integer.MAX_VALUE;
        for(ElavatorController controller:elavatorControllers) {
            int distance = Math.abs(controller.getElavatorPosition() - dstFloor.floorId);
            if(distance<minDistance) {
                minDistance = distance;
                nearest = controller;
            }
        }
        // System.out.println("lift-"+nearest.getElavatorId()+" called for dstFloor-"+dstFloor.floorId);
        nearest.acceptExternalRequest(dstFloor.floorId, dir);
    }
}