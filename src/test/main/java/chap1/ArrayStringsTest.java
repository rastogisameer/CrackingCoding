package chap1;

import org.junit.Test;

public class ArrayStringsTest {

    @Test
    public void testIsAllUniqueChars(){
        ArrayStrings obj = new ArrayStrings();
        System.out.println(obj.isAllUniqueChars("fabcdef"));
    }
    @Test
    public void testReverse(){
        ArrayStrings obj = new ArrayStrings();
        System.out.println(obj.reverse("abcdef"));
    }
    @Test
    public void testRemoveDuplicates(){
        ArrayStrings obj = new ArrayStrings();
        System.out.println(obj.removeDuplicates("fabcdef"));
    }
    @Test
    public void testIsAnagram(){
        ArrayStrings obj = new ArrayStrings();

    }
}
