package elevator;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class LiftController {

    private List<Lift> lifts = new ArrayList<Lift>();

    public LiftController(){

    }
    public List<Future> init(){

        Lift l1 = new Lift(1);
        Lift l2 = new Lift(2);
        lifts.add(l1);
        System.out.println("++ " + l1);
        lifts.add(l2);
        System.out.println("++ " + l2);

        ExecutorService pool = Executors.newFixedThreadPool(2);

        List<Future> futs = new ArrayList<Future>();

        futs.add(pool.submit(l1));
        futs.add(pool.submit(l2));

        return futs;
    }
    public void shutdown(List<Future> futs){

        for(Future f: futs ){
            try {
                f.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
    public Lift call(int srcFloor, int direction){

        Lift lift = findLift(srcFloor, direction);

        boolean success = lift.call(new LiftRequest(srcFloor, direction));
        return lift;
    }
    private Lift findLift(int srcFloor, int direction){

        Iterator<Lift> iter = lifts.iterator();
        Lift lift = null;

        while(iter.hasNext()){
            lift = iter.next();

           if(lift.getMovingDirection() == LiftRequest.STATION){
               break;
           } else if(lift.getMovingDirection() == LiftRequest.DOWN){

           } if(lift.getMovingDirection() == LiftRequest.UP){

           }
        }
        System.out.println(lift + " => " + srcFloor);
        return lift;
    }

}
