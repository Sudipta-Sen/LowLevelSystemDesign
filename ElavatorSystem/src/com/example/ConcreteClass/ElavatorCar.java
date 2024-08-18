package com.example.ConcreteClass;

import com.example.enums.*;

public class ElavatorCar {
    int elavatorId;
    Display dis;
    ElavatorDirection dir;
    ElavatorStatus status;
    InternalButtons internalButtons;
    int curFloor;

    public ElavatorCar(int id) {
        this.elavatorId = id;
        this.status = ElavatorStatus.Ideal;
        this.dir = ElavatorDirection.UP;
        this.curFloor = 0;
        internalButtons = new InternalButtons();
    }

    public void move(int dstFloor, ElavatorDirection dir) {
        System.err.println("Current floor of elavator-"+elavatorId+"= "+this.curFloor);
        this.dir = dir;
        System.err.println("Going "+dir+" to reach floor-"+dstFloor);
        this.curFloor = dstFloor;
    }

    public void pressButton(int floorId) {
        internalButtons.pressButton(floorId, this);
    }

}