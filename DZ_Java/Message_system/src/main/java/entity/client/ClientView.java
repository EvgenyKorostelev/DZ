package entity.client;

import entity.Message;


public interface ClientView {

    void actionLoginClient();

    void actionSendMessageClient();

    void showTextAllMessagesClient(String string);

    Message generateMessage();

    String findAllTextMessages();

    String findUserLogin();
}
