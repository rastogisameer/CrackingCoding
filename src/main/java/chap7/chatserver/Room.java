package chap7.chatserver;

import java.util.ArrayList;
import java.util.List;

public class Room {

    private List<User> members = new ArrayList<User>();

    public void addUser(User user){
        members.add(user);
    }
    public void removeUser(User user){
        members.remove(user);
    }
    public boolean isMember(User user){
        return members.contains(user);
    }
}
