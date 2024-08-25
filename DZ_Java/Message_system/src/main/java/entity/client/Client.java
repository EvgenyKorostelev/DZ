package entity.client;

import entity.IdFactory;
import entity.Message;
import entity.server.Server;

import java.io.IOException;


public class Client {

    private int clientId;
    private Server server;
    private ClientView clientView;
    private boolean clientStatus;
    private String user;

    public Client() {
        try {
            IdFactory idFactory = new IdFactory();
            clientId = idFactory.createId();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isClientStatus() {
        return clientStatus;
    }

    public void setClientView(ClientView clientView) {
        this.clientView = clientView;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    public void setClientStatus(boolean clientStatus) {
        this.clientStatus = clientStatus;
    }

    public void connectToServer() {
        if (server.isServerStatus() && !clientView.findUserLogin().isEmpty() && !this.clientStatus) {
            user = clientView.findUserLogin();
            clientStatus = true;
            server.addClientToList(this);
            clientView.showTextAllMessagesClient(server.findAllTextMessages()
                    + "Вы подключены к серверу" + "\n");
            server.showTextAllMessages("Пользователь " + clientView.findUserLogin()
                    + " присоединился к серверу");
        } else if (!server.isServerStatus()) {
            clientView.showTextAllMessagesClient(clientView.findAllTextMessages()
                    + "Сервер недоступен Connection Failed !!!" + "\n");
        } else if (server.isServerStatus() && clientView.findUserLogin().isEmpty()) {
            clientView.showTextAllMessagesClient(clientView.findAllTextMessages()
                    + "Заполните поле Login." + "\n");
        }
    }

    public void disconnectFromServer() {
        this.clientStatus = false;
        server.removeClientFromList(this);
        if(!clientView.findAllTextMessages().isEmpty() && server.isServerStatus()) {
            clientView.showTextAllMessagesClient(clientView.findAllTextMessages()
                    + "Вы отключены от сервера" + "\n");
            server.showTextAllMessages("Пользователь " + clientView.findUserLogin()
                    + " отключился от сервера");
        }
    }

    public void sendMessage() {
        if (server.isServerStatus() && this.clientStatus) {
            Message message = clientView.generateMessage();
            if(!message.getTextMessage().isEmpty()){
            server.saveMessage(message);
            String textToDisplay = generateTextMessage(message);
            server.updateTextAllMessages(textToDisplay);
            clientView.showTextAllMessagesClient(clientView.findAllTextMessages()
                    + textToDisplay);
            }
        }
    }

    public void updateFieldAllMessages() {
        if (server.isServerStatus() && this.clientStatus) {
            clientView.showTextAllMessagesClient("Вы подключены к серверу" + "\n"
                    + server.findAllTextMessages());
        }
    }

    private String generateTextMessage(Message message) {
        return message.getDateMessage() + " "
                + message.getAuthorMessage() + ": "
                + message.getTextMessage() + "\n";
    }
}

