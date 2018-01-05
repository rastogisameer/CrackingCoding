package meeting;

import java.util.Date;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;

public class MeetingRoom {

    private TreeSet<Meeting> schedule = new TreeSet<Meeting>();

    public boolean makeBooking(Date start, int duration){

        boolean success = false;
        if(canBook(start, duration)){
            success = schedule.add(new Meeting(start, duration));
            System.out.println(this + " <- " + start + " - " + duration + ": " + success);
        }
        return success;
    }
    public boolean cancelBooking(Date start, int duration){
        return schedule.remove(new Meeting(start, duration));
    }
    public void showBookings(){
        System.out.println("---------------------------------------------------------");
        Iterator<Meeting> iter = schedule.iterator();
        while(iter.hasNext()){
            Meeting m = iter.next();
            System.out.println(this + " <- " + m.getStart() + " - " + m.getDuration());
        }
        System.out.println("---------------------------------------------------------");
    }
    public boolean canBook(Date start, int duration){
        Date end = new Date(start.getTime() + duration*60*1000);

        Iterator<Meeting> iter = schedule.iterator();
        while(iter.hasNext()){
            Meeting m = iter.next();

            if(
                    (start.getTime() > m.getStart().getTime() && start.getTime() < m.getEnd().getTime())
                    ||
                    (end.getTime() > m.getStart().getTime() && end.getTime() < m.getEnd().getTime())
               ) {
                System.out.println(this + " <- " + start + " - " + duration + ": false");
                return false;
            }
        }
        return true;
    }

}
