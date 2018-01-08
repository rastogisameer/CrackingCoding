package chap7.chatserver;

public class Session implements Runnable{
    private User user;
    private Room room;

    public User getUser() {
        return user;
    }

    public Room getRoom() {
        return room;
    }

    public Session(User u, Room r){
        this.user = u;
        this.room = r;
    }

    @Override
    public void run() {

    }

    public void postMessage(Message m){

    }
    public void close(){
        Thread.currentThread().interrupt();
    }
}
