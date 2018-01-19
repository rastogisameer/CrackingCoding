package chap12.socialnetwork;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class NetworkTest {

    @Test
    public void testShowConnection(){

        Network network = new Network();

        network.addMember("A");
        network.addMember("B");
        network.addMember("C");
        network.addMember("D");
        network.addMember("E");
        network.addMember("F");
        network.addMember("G");

        network.connect("A", "B");
        network.connect("A", "D");
        network.connect("A", "C");

        //network.connect("B", "E");
        //network.connect("B", "F");
        network.connect("D", "E");

        network.connect("F", "G");
        network.connect("E", "G");

        List<String> path = new ArrayList<String>();

        network.showConnection("D", "E", path);

        path.stream().forEach(System.out::print);
    }
}
