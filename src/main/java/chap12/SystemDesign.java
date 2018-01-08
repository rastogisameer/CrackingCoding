package chap12;

import java.util.List;

public class SystemDesign {

    public int getNewInteger(int[] numbers){

        int m = numbers[0];
        for(int n: numbers){

            if(m == n){
                m = n + 1;
            }
        }
        return m;
    }


}
