package com.example.Interface;

import com.example.enums.ElavatorDirection;
import com.example.ConcreteClass.Floor;

public interface  ExternalButtonDispatcher {
    public void submitRequest(Floor floor, ElavatorDirection dir);
}