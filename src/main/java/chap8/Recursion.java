package chap8;

import java.util.*;

public class Recursion {

    public void subsets(Set<Integer> set, List<Set> subs){

        Integer[] arr = set.toArray(new Integer[set.size()]);

        if(arr.length == 1){
            Set<Integer> s1 = new HashSet<Integer>();
            s1.add(arr[0]);
            subs.add(s1);
        }
        if(arr.length == 2) {

            Set<Integer> s1 = new HashSet<Integer>();
            s1.add(arr[0]);
            subs.add(s1);

            Set<Integer> s2 = new HashSet<Integer>();
            s2.add(arr[1]);
            subs.add(s2);

            Set<Integer> s3 = new HashSet<Integer>();
            s3.add(arr[0]);
            s3.add(arr[1]);
            subs.add(s3);

//            Set<Integer> s4 = new HashSet<Integer>();
//            s4.add(arr[1]);
//            s4.add(arr[0]);
//            subs.add(s4);
        } else {

            Set<Integer> s1 = new HashSet<Integer>();
            Integer i1 = arr[0];
            s1.add(i1);
            subs.add(s1);

            Set<Integer> s2 = new HashSet<Integer>();
            for (int i = 1; i < arr.length; i++) {
                s2.add(arr[i]);
            }
            subsets(s2, subs);

            Set[] sets = subs.toArray(new HashSet[subs.size()]);
            for(Set s3: sets){

                Set<Integer> s4 = new HashSet<Integer>();
                s4.add(i1);
                s4.addAll(s3);
                subs.add(s4);
//
//                Set<Integer> s5 = new HashSet<Integer>();
//                s5.addAll(s3);
//                s5.add(i1);
            }
        }
    }

}
