package chap7.chatserver;

public class Client {

    public Session login(User user, Room room){

        Server server = Server.getInstance();
        Session session = server.authenticate(user, room);

        return session;
    }
    public void postMessage(Session session, Message message){

        session.postMessage(message);
    }
    public Message getMessages(){
        return null;
    }

    public void logout(User user, Room room){
        Server server = Server.getInstance();
        server.invalidate(user);
    }
}
