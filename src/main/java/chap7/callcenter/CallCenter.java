package chap7.callcenter;

import java.util.LinkedList;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class CallCenter {

    private LinkedBlockingQueue<Employee> availableEmployees = new LinkedBlockingQueue<Employee>();
    AtomicInteger employeeIds = new AtomicInteger();

    private ExecutorService employees = Executors.newFixedThreadPool(5);

    public CallCenter() {
    }
    public void init(){
        Employee manager = new ProdManager(employeeIds.incrementAndGet(), null,this);
        employees.submit(manager);
        Employee lead = new TechLead(employeeIds.incrementAndGet(), manager,this);
        employees.submit(lead);

        Employee fresher1 = new Fresher(employeeIds.incrementAndGet(), lead, this);
        employees.submit(fresher1);
        Employee fresher2 = new Fresher(employeeIds.incrementAndGet(), lead, this);
        employees.submit(fresher2);
        Employee fresher3 = new Fresher(employeeIds.incrementAndGet(), lead, this);
        employees.submit(fresher3);

        availableEmployees.add(fresher1);
        availableEmployees.add(fresher2);
        availableEmployees.add(fresher3);
    }

    private Employee getCallHandler(){

        Employee emp = null;
        try {
            emp = availableEmployees.take();

            System.out.println("++ " + emp.getType() + emp.getEmployeeId());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return emp;
    }
    public void callCompleted(Employee emp){
        try {
            availableEmployees.put(emp);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void handleCall(CallRequest call){

        Employee emp = getCallHandler();
        emp.handle(call);
    }
}
