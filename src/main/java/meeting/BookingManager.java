package meeting;

import java.util.Date;

public class BookingManager {

    private MeetingRoom room1 = new MeetingRoom();

    public boolean makeBooking(Date start, int duration){
        return room1.makeBooking(start, duration);
    }
    public boolean cancelBooking(Date start, int duration){
        return room1.cancelBooking(start, duration);
    }
    public void showBookings(){
        room1.showBookings();
    }
}
