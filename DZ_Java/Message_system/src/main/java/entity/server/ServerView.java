package entity.server;

public interface ServerView {

    void actionStartServer();

    void actionStopServer();

    void showTextAllMessagesServer(String string, boolean serverStatus);

    String findAllTextMessages();

    void updateFieldAllMessages(String string);
}
