package com.example.ConcreteClass;

import com.example.enums.*;

public class PendingJobs {
    int dstFloor;
    ElavatorDirection dir;

    public PendingJobs(int dstFloor, ElavatorDirection dir) {
        this.dstFloor = dstFloor;
        this.dir = dir;
    }
}