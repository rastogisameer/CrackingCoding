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
    public List<List<Integer>> cents(int n){

        List<List<Integer>> ways = new ArrayList<List<Integer>>();

        if(n < 5){
            List<Integer> w1 = new ArrayList<Integer>();
            for (int i = 1; i<= n; i++ ){
                w1.add(1);
            }
            ways.add(w1);
            return ways;
        }

        if(n >= 5 && n < 10){
            List<List<Integer>> ways2 = cents(n-1);

            for(List<Integer> way: ways2){
                way.add(1);
            }

            List<List<Integer>> ways3 = cents(n-5);

            for(List<Integer> way: ways3){
                way.add(5);
            }
            ways.addAll(ways2);
            ways.addAll(ways3);
        }
        return ways;
    }
}
