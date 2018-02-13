package cpd;

public class CopyPaste {

    public int square1(int num){

        int added = num * num;
        return added;
    }
    public int square2(int num){

        int added = 0;
        for(int i = 1; i <= num; i++){
            added += num;
        }
        return added;
    }
    public int square3(int num){

        int added = (int) Math.pow(num, 2);
        return added;
    }
    public int square4(int num){

        int added = num * num;
        return added;
    }
    public int square5(int num){

        int mult = num * num;
        return mult;
    }
}
