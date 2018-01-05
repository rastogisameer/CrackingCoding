package chap7.callcenter;

import java.util.Date;

public class CallRequest {

    static final int MIN_DELAY = 1;
    static final int MAX_DELAY = 200;

    private int num;
    public CallRequest(int num){
        this.num = num;
    }

    public String getWork() {
        return  "work" + num;
    }
}
