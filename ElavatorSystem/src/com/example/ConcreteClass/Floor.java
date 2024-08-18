package com.example.ConcreteClass;

import com.example.Interface.ExternalButtonDispatcher;
import com.example.enums.*;

public class Floor {
    int floorId;
    ExternalButton exButton;

    public Floor(int floorId) {
        this.floorId = floorId;
        this.exButton = null;
    }

    public void setExternalButton(ExternalButtonDispatcher dispatcher) {
        this.exButton = new ExternalButton(dispatcher);
    }

    public void pressUpButton() {
        if(exButton==null) {
            System.out.println("External button is not yet set");
            return;
        }
        exButton.pressButton(ElavatorDirection.UP, this);
    }

    public void pressDownButton() {
        if(exButton==null) {
            System.out.println("External button is not yet set");
            return;
        }
        exButton.pressButton(ElavatorDirection.DOWN, this);
    }
}