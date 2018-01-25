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
        set.add(2);
        set.add(3);
        set.add(4);

        List<Set> subs = new ArrayList<Set>();

        recur.subsets(set, subs);

        for(Set s: subs){
            s.forEach(i -> System.out.print(i + ", "));
            System.out.println(" ");
        }
    }
    @Test
    public void testCents(){
        Recursion recur = new Recursion();
        List<List<Integer>> ways = recur.cents(9);

        for(List<Integer> way : ways){

            way.forEach(i -> System.out.print(i + ","));
            System.out.println(" ");
        }
    }
}
