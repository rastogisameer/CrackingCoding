package elevator;

import org.junit.Test;

import java.io.Console;
import java.util.List;
import java.util.concurrent.Future;

public class LiftControllerTest {

    @Test
    public void testCall(){

        LiftController controller = new LiftController();
        List<Future> futs = controller.init();

        Lift l1 = controller.call(3, LiftRequest.UP);
        l1.lift(5);

        Lift l2 = controller.call(3, LiftRequest.DOWN);
        l2.lift(2);

        Lift l3 = controller.call(7, LiftRequest.UP);


        controller.shutdown(futs);
    }
}
