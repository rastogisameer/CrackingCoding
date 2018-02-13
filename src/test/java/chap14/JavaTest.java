package chap14;

import org.junit.Test;

public class JavaTest {
    @Test
    public void testPrivateConstructor(){

        Parent1 obj1 = new Child1();
        System.out.println(obj1.val);

        obj1.show();
    }
}
