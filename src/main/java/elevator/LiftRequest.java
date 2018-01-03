package elevator;

import java.util.concurrent.atomic.AtomicInteger;

public class LiftRequest {

    public static final int UP = +1;
    public static final int DOWN = -1;
    public static final int STATION = 0;

    private int direction;
    private int floor;
    private int requestId;

    private static AtomicInteger requestIds = new AtomicInteger();

    public LiftRequest(int floor, int direction){

        this.floor = floor;
        this.direction = direction;
        this.requestId = requestIds.incrementAndGet();
    }

    public int getRequestId() {
        return requestId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LiftRequest that = (LiftRequest) o;

        return requestId == that.requestId;
    }

    @Override
    public int hashCode() {

        return requestId;
    }

    public LiftRequest(int floor){

        this.floor = floor;
    }
    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

}
