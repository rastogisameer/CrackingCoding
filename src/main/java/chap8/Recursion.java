package chap8;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Recursion {

    public void subsets(Set<Integer> set, List<Set> subs){

        Integer[] arr = set.toArray(new Integer[set.size()]);

        if(arr.length == 1){
            Set<Integer> s1 = new HashSet<Integer>();
            s1.add(arr[0]);
            subs.add(s1);
        }

        Set<Integer> s1 = new HashSet<Integer>();
        s1.add(arr[0]);
        subs.add(s1);

        Set<Integer> s2 = new HashSet<Integer>();
        subs.add(s2);
        for(int i = 1; i< arr.length; i++){
            s2.add(arr[i]);
        }
        subsets(s2, subs);
    }

}
