package com.example.ConcreteClass;

import com.example.enums.ElavatorDirection;
import com.example.enums.ElavatorStatus;
import java.util.*;

public class ElavatorController {
    ElavatorCar elavatorCar;
    PriorityQueue<Integer> upMinPQ;
    PriorityQueue<Integer> downMaxPQ;
    List<PendingJobs> pendingJobs;

    public ElavatorController(ElavatorCar elavatorCar) {
        this.elavatorCar = elavatorCar;
        upMinPQ = new PriorityQueue<>();
        downMaxPQ = new PriorityQueue<>((Integer a, Integer b) -> (b-a));
        pendingJobs = new ArrayList<>();
    }
    
    public void acceptInternalRequest(int dstFloor) {
        int curFloor = elavatorCar.curFloor;
        int diff = dstFloor - curFloor;

        if(diff>0) {
            // request come for destination floor above
            if(!upMinPQ.contains(dstFloor)) upMinPQ.offer(dstFloor);
        } else if(diff<0) {
            // request come for destination floor down
            if(!downMaxPQ.contains(dstFloor)) downMaxPQ.offer(dstFloor); 
        } else {
            System.out.println("Same floor request can't be taken");
        }
    }

    public void acceptExternalRequest(int dstFloor, ElavatorDirection requestedDirection) {
        int curFloor = elavatorCar.curFloor;
        int diff = dstFloor - curFloor;
        // System.out.println("External request comes, dstFloor"+dstFloor+", curFloor"+curFloor+", direction="+requestedDirection);
        if(diff==0) {
            System.out.println("Same floor request can't be taken");
            return;
        }
        ElavatorDirection curDir = elavatorCar.dir;
        if(requestedDirection==ElavatorDirection.UP && curDir==ElavatorDirection.UP) {
            if(diff>0) {
                // System.out.println("External request pushed in upMinPQ");
                upMinPQ.offer(dstFloor);
            }
            else {
                // System.out.println("External request pushed in pending jobs");
                pendingJobs.add(new PendingJobs(dstFloor, requestedDirection));
            }

        } else if (requestedDirection==ElavatorDirection.DOWN && curDir==ElavatorDirection.DOWN) {
            if(diff<0) {
                // System.out.println("External request pushed in downMaxPQ");
                downMaxPQ.offer(dstFloor);
            }
            else {
                // System.out.println("External request pushed in pending jobs down");
                pendingJobs.add(new PendingJobs(dstFloor, requestedDirection));
            }

        } else if (requestedDirection==ElavatorDirection.UP && curDir==ElavatorDirection.DOWN) {
            upMinPQ.offer(dstFloor);
        } else {
            downMaxPQ.offer(dstFloor);
        }
    }

    public void controlElavatorCar() {
        while (!upMinPQ.isEmpty() || !downMaxPQ.isEmpty()) { 
            elavatorCar.status = ElavatorStatus.Moving;
            if(elavatorCar.dir == ElavatorDirection.DOWN) {
                while(! downMaxPQ.isEmpty()) {
                    int nextFloorId = downMaxPQ.poll();
                    int curFloor = elavatorCar.curFloor;
                    if(curFloor>nextFloorId) elavatorCar.move(nextFloorId, ElavatorDirection.DOWN);
                    else if(curFloor<nextFloorId) elavatorCar.move(nextFloorId, ElavatorDirection.UP);
                    else System.out.println("Lift is at floor-"+curFloor+" serving the request at floor-"+curFloor);
                }
                elavatorCar.dir = ElavatorDirection.UP;
                for(PendingJobs jobs:pendingJobs) {
                    downMaxPQ.offer(jobs.dstFloor);
                }
            } else {
                while(! upMinPQ.isEmpty()) {
                    int nextFloorId = upMinPQ.poll();
                    int curFloor = elavatorCar.curFloor;
                    if(curFloor>nextFloorId) elavatorCar.move(nextFloorId, ElavatorDirection.DOWN);
                    else if(curFloor<nextFloorId) elavatorCar.move(nextFloorId, ElavatorDirection.UP);
                    else System.out.println("Lift is at floor-"+curFloor+" serving the request at floor-"+curFloor);
                }
                elavatorCar.dir = ElavatorDirection.DOWN;
                for(PendingJobs jobs:pendingJobs) {
                    upMinPQ.offer(jobs.dstFloor);
                }
            }
        }
        elavatorCar.status = ElavatorStatus.Ideal;
    }

    public int getElavatorId() {
        return elavatorCar.elavatorId;
    }

    public int getElavatorPosition() {
        return elavatorCar.curFloor;
    }
    
}