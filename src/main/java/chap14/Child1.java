package chap14;

public class Child1 extends Parent1 {
    int val = 11;
    public Child1(){
        System.out.println("Child1 constructor called");
    }
    public void show(){
        System.out.println("Child1 value " + val);
    }
}
