package com.example.ConcreteClass;

import com.example.Interface.ExternalButtonDispatcher;
import com.example.enums.*;

public class ExternalButton {
    // ElavatorDirection dir;
    ExternalButtonDispatcher externalDispatcher;

    public ExternalButton (ExternalButtonDispatcher externalDispatcher) {
        this.externalDispatcher = externalDispatcher;
    } 

    public void pressButton(ElavatorDirection dir, Floor floor) {
        externalDispatcher.submitRequest(floor, dir);
    }
}