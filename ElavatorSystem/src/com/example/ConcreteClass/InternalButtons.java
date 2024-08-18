package com.example.ConcreteClass;

public class InternalButtons {
    InternalButtonDispatcher dispatcher = new InternalButtonDispatcher();
    // int []availableButtons = {1,2,3,4,5,6};

    public InternalButtons() {
    }

    public void pressButton(int destination, ElavatorCar elavatorCar) {
        dispatcher.submitRequest(destination, elavatorCar);
    }

    

}