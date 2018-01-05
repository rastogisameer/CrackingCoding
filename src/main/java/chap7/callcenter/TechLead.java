package chap7.callcenter;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

public class TechLead extends Employee {
    private String type = "Leader";
    protected String getType(){
        return type;
    }
    public TechLead(int employeeId, Employee escalateEmp, CallCenter center) {
        super(employeeId, escalateEmp, center);
    }

    @Override
    public boolean handleCall(CallRequest call) {
        System.out.println(type + employeeId + " => " + call.getWork());

        int delay = ThreadLocalRandom.current().nextInt(CallRequest.MIN_DELAY,CallRequest.MAX_DELAY);
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        boolean canHandle = ThreadLocalRandom.current().nextBoolean();
        System.out.println(type + employeeId + " => " + call.getWork() + " ~~ " + canHandle);

        //center.callCompleted(this);

        return canHandle;
    }

}
