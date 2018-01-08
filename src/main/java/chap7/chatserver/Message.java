package chap7.chatserver;

public class Message {

    private User user;
    private String message;

    public Message(User user, String message) {
        this.user = user;
        this.message = message;
    }
}
