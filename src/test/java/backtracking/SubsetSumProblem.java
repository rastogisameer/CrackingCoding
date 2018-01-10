package backtracking;

import java.util.List;

public class SubsetSumProblem {

    public void getSubsetWithSum(List<Integer> arr, int sum, List<Integer> subset){



        if(sum(subset) < sum){


        }
    }
    private int sum(List<Integer> subset){

        return subset.stream().reduce((t1, t2) -> t1+t2).get();
    }

}
