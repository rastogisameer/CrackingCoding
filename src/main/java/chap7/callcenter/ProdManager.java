package chap7.callcenter;

import jdk.nashorn.internal.codegen.CompilerConstants;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

public class ProdManager extends Employee {
    private String type = "Manager";
    protected String getType(){
        return type;
    }
    LinkedBlockingQueue<CallRequest> queue = new LinkedBlockingQueue<CallRequest>();

    public ProdManager(int employeeId, Employee escalateEmp, CallCenter center) {
        super(employeeId, escalateEmp, center);
    }

    public void handle(CallRequest call) {
        try {
            queue.put(call);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run() {

        while (true) {

            try {
                CallRequest req = queue.take();

                handleCall(req);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
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
        return true;

    }
}
