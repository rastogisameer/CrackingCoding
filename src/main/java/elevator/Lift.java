package elevator;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Lift implements Runnable{

    public static final int DELAY = 200;

    private int liftId;
    private int currentFloor;
    private int movingDirection;

    private PriorityQueue<LiftRequest> upQ = new PriorityQueue<LiftRequest>(new Comparator<LiftRequest>() {
        @Override
        public int compare(LiftRequest o1, LiftRequest o2) {

            return o1.getRequestId() - o2.getRequestId();
        }
    });
    private PriorityQueue<LiftRequest> downQ = new PriorityQueue<LiftRequest>(new Comparator<LiftRequest>() {
        @Override
        public int compare(LiftRequest o1, LiftRequest o2) {

            return o2.getRequestId() - o1.getRequestId();
        }
    });

    public Lift(int id){
        this.liftId = id;
    }

    public int getLiftId() {
        return liftId;
    }

    public boolean isAvailable(){
        return upQ.isEmpty() && downQ.isEmpty();
    }
    public int getCurrentFloor() {
        return currentFloor;
    }

    public boolean call(LiftRequest req){

        if(req.getDirection() == LiftRequest.DOWN) {

           return downQ.add(req);

        } else if(req.getDirection() == LiftRequest.UP) {

            return upQ.add(req);

        }
        return false;
    }
    public boolean lift(int destFloor){

        LiftRequest req = new LiftRequest(destFloor);

        if(req.getDirection() == 0){

            int direction = (currentFloor > req.getFloor()? LiftRequest.DOWN : LiftRequest.UP);
            req.setDirection(direction);
        }
        return call(req);
    }
    public void run(){

        while(true){

            movingDirection = getMovingDirection();
            LiftRequest req = null;

            req = upQ.poll();

            if(req == null){

                req = downQ.poll();
            }
            if(req != null) {
                moveTo(req);

                currentFloor++;

            }
        }
    }
    public int getMovingDirection(){

        if(upQ.isEmpty() && downQ.isEmpty()){
            movingDirection = LiftRequest.STATION;
        } else if(upQ.isEmpty() && !downQ.isEmpty()){
            movingDirection = LiftRequest.DOWN;
        } else if(!upQ.isEmpty() && downQ.isEmpty()){
            movingDirection = LiftRequest.UP;
        } else {
            movingDirection = LiftRequest.UP;
        }
        return movingDirection;
    }
    private void moveTo(LiftRequest req){

        System.out.println("Lift" + liftId + ": " + currentFloor + " --> " + req.getFloor());

        try {
            Thread.sleep(DELAY ) ;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        currentFloor = req.getFloor();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lift lift = (Lift) o;

        return liftId == lift.liftId;
    }

    @Override
    public int hashCode() {
        return liftId;
    }

}
