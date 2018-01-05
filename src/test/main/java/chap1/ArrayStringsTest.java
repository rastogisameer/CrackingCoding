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
        System.out.println(obj.isAnagram("abcd", "dbca"));
    }
    @Test
    public void testRotateBy90(){
        ArrayStrings obj = new ArrayStrings();

        char[][] arr = {
            {'a','b','c','d'},
            {'e','f','g','h'},
            {'i','j','k','l'},
            {'m','n','o','p'}
        };
        obj.rotateBy90(arr);
        obj.showArray(arr);

    }
    @Test
    public void testGetFirstDuplicate(){
        ArrayStrings obj = new ArrayStrings();

        System.out.println(obj.getFirstDuplicate("gfedcbaha"));
    }
    @Test
    public void testGetWordsSortedByCount(){
        ArrayStrings obj = new ArrayStrings();
        String[] arr = obj.getWordsSortedByCount("The man stood up and lifted the child on his arms repeating the words the older man said when he died.");
        obj.showArray(arr);
    }
    @Test
    public void testSetRowAndCol(){
        int[][] arr = {
                {1,2,3,4},
                {3,4,2,5},
                {6,7,8,3},
                {1,4,7,2}
        };
        ArrayStrings obj = new ArrayStrings();
        obj.setRowAndCol(arr,2);
        obj.showArray(arr);
    }
}
