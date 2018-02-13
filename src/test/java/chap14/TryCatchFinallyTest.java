package chap14;

import org.junit.Test;

import java.text.ParseException;

public class TryCatchFinallyTest {

    @Test
    public void testFinally(){

        TryCatchFinallyTest obj = new TryCatchFinallyTest();

        System.out.println(obj.getState());
    }
    public int getState(){

        try{

            Integer.parseInt("1a");

            return 1;

        } catch (NumberFormatException x){
            System.out.println(x.getMessage());

            return -1;

        } finally {
            return 2;
        }
        //return 0;
    }
}
