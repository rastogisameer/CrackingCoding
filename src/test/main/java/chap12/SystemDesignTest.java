package chap12;

import org.junit.Test;

public class SystemDesignTest {
    @Test
    public void testGetNewInteger(){

        SystemDesign obj = new SystemDesign();
        int[] nums = {12,45,32,76,89,2,4,6,78,34,76,4,5,87,3};

        System.out.println(obj.getNewInteger(nums));
    }
}
