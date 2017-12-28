package chap7.callcenter;

import java.util.concurrent.ThreadLocalRandom;

import static java.util.concurrent.ThreadLocalRandom.current;

public abstract class Employee implements Runnable{

    protected String type = "Employee";
    protected abstract String getType();

    protected CallCenter center;

    private Employee escalateEmp;

    private CallRequest call;

    protected int employeeId;

    public int getEmployeeId(){
        return employeeId;
    }

    public Employee(int employeeId, Employee escalateEmp, CallCenter center){
        this.employeeId = employeeId;
        this.escalateEmp = escalateEmp;
        this.center = center;
    }
    public void handle(CallRequest call){

        if(this.call != null){
            System.out.println(this.getType() + this.employeeId + " !!");
            escalateEmp.handle(call);
        } else {
            this.call = call;
        }
    }
    public void run(){

        while(true){

            if(call != null){
                boolean canHandle = handleCall(call);

                if(!canHandle){
                    escalateEmp.handle(call);
                }
                call = null;
            }
        }
    }
    protected abstract boolean handleCall(CallRequest call);

}
