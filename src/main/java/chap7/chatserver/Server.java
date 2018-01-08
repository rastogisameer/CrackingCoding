package chap7.chatserver;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server implements Runnable {

    public static final int MAX_SESSIONS = 5;
    private static Server server;

    private Map<User, Session> sessionMap = new HashMap<User, Session>();

    ExecutorService sessionPool = Executors.newFixedThreadPool(MAX_SESSIONS);

    private Server(){

    }
    public void shutdown(){
        sessionPool.shutdown();
    }

    public static synchronized Server getInstance(){

        if(server == null){
            server = new Server();
        }
        return server;
    }

    @Override
    public void run() {

    }
    public Session authenticate(User user, Room room){

        if(room.isMember(user)){

            Session session = new Session(user, room);
            sessionMap.put(user, session);

            sessionPool.submit(session);

            return session;
        }
        throw new RuntimeException("Authentication Failed");
    }
    public void invalidate(User user){

        Session session = sessionMap.get(user);

        session.close();

        sessionMap.remove(user);
    }
}
