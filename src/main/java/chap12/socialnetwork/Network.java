package chap12.socialnetwork;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Network {

    private Map<String, List<String>> nodes;

    public Network(){
        nodes = new HashMap<String, List<String>>();
    }
    public void addMember(String user){
        nodes.put(user, new ArrayList<String>());
    }
    public void connect(String user1, String user2){

        if(nodes.containsKey(user1)) {

            List<String> connections1 = nodes.get(user1);
            connections1.add(user2);

            List<String> connections2 = nodes.get(user2);
            connections2.add(user1);

        } else {

            List<String> connections1 = new ArrayList<String>();
            connections1.add(user2);

            nodes.put(user1, connections1);

            List<String> connections2 = new ArrayList<String>();
            connections2.add(user1);

            nodes.put(user2, connections2);
        }
    }
    public int showConnection(String user1, String user2, List<String> path){

        int validpath = 1;

        path.add(user1);

        if(user1.equalsIgnoreCase(user2)){
            return 1;
        }
        List<String> connections = nodes.get(user1);

        if(connections.size() -1 == 0){
            path.remove(user1);
            return -1;
        }
        for(String user: connections){

            validpath = 1;

            if(path.contains(user)){
                continue;
            }
            if(!path.contains(user2)){
                validpath = showConnection(user, user2, path);

                if(validpath == -1){
                    path.remove(user);
                }
            }
        }
        return validpath;
    }
}
