package chap7.callcenter;

import org.junit.Test;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class CallCenterTest {
    AtomicInteger workNums = new AtomicInteger();
    @Test
    public void testHandleCall(){
        int MAX_CALLS = 50;
        CallCenter center = new CallCenter();

        center.init();

        for(int i = 0; i < MAX_CALLS; i++){

            int delay = ThreadLocalRandom.current().nextInt(CallRequest.MIN_DELAY,CallRequest.MAX_DELAY);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            CallRequest req = new CallRequest(workNums.getAndIncrement());
            center.handleCall(req);
        }
    }
}
