package elevator;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    private PriorityQueue<LiftRequest> upQ = new PriorityQueue<LiftRequest>(new Comparator<LiftRequest>() {
        @Override
        public int compare(LiftRequest o1, LiftRequest o2) {

            return o1.getRequestId() - o2.getRequestId();
        }
    });

    public void main(){

        upQ.add(new LiftRequest(3, LiftRequest.DOWN));

        System.out.println(upQ);
    }
    public static void main(String...args){
        Main m = new Main();
        m.main();
    }
}
