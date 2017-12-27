package chap1;

import org.junit.Test;

public class ArrayStringsTest {

    @Test
    public void testIsAllUniqueChars(){
        ArrayStrings obj = new ArrayStrings();
        System.out.println(obj.isAllUniqueChars("fabcdef"));
    }
}
