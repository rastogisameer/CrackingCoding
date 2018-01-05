package chap7.parking;

import java.util.*;

public class ParkingLot {

    private Queue<ParkingSpot> availableSpots = new LinkedList<ParkingSpot>();
    private Queue<ParkingSpot> parkedSpots = new LinkedList<ParkingSpot>();

    public ParkingLot(){
        ParkingSpot p1 = new ParkingSpot();
        availableSpots.add(p1);

        ParkingSpot p2 = new ParkingSpot();
        availableSpots.add(p2);

        ParkingSpot p3 = new ParkingSpot();
        availableSpots.add(p3);
    }

    public boolean isParkingSpotAvailable(int spotId){
        return true;
    }
    public ParkingSpot getAvailableParkingSpot(){

        ParkingSpot p = availableSpots.remove();
        parkedSpots.add(p);
        return p;

    }
    public Permission getPermission(Date startTime, Date endTime){

        Permission m = new Permission();
        m.setStartTime(startTime);
        m.setEndTime(endTime);

        ParkingSpot p = getAvailableParkingSpot();
        return null;
    }

}
