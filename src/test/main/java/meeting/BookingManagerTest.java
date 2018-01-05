package meeting;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class BookingManagerTest {

    @Test
    public void testMakeBooking(){

        SimpleDateFormat format = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");

        BookingManager manager = new BookingManager();
        try {
            manager.makeBooking(format.parse("02-01-2018 11:30:00"), 60);

            manager.makeBooking(format.parse("02-01-2018 09:00:00"), 60);

            manager.makeBooking(format.parse("02-01-2018 10:00:00"), 120);

            manager.makeBooking(format.parse("02-01-2018 10:00:00"), 30);

            manager.makeBooking(format.parse("02-01-2018 10:00:00"), 30);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        manager.showBookings();
    }
}
