package chap8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RecursionTest {

    @Test
    public void testSubsets(){

        Recursion recur = new Recursion();

        Set<Integer> set = new HashSet<Integer>();
        set.add(1);
        //set.add(2);

        List<Set> subs = new ArrayList<Set>();

        recur.subsets(set, subs);

        for(Set s: subs){
            s.forEach(System.out::println);
        }

    }
}
