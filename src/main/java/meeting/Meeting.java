package meeting;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Meeting implements Comparable<Meeting>{

    private Date start;
    private transient Date end;
    private int duration;

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }

    public int getDuration() {
        return duration;
    }

    public Meeting(Date start, int duration){
        this.start = start;
        this.duration = duration;
        this.end = new Date(start.getTime() + duration*60*1000);
    }

    @Override
    public int compareTo(Meeting that) {

        if(this.start.getTime() == that.start.getTime()){
            return this.duration - that.duration;
        } else {
            return (int) (this.start.getTime() - that.start.getTime());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Meeting meeting = (Meeting) o;

        if (duration != meeting.duration) return false;
        if(this.start.getTime() != meeting.start.getTime()) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = start != null ? start.hashCode() : 0;
        result = 31 * result + duration;
        return result;
    }
}
