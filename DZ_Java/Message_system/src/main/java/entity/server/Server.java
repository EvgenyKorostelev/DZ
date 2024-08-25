package entity.server;

import entity.Message;
import entity.client.Client;
import repository.ReadFromFile;
import repository.SaveToFile;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Server {

    private boolean serverStatus;
    private ServerView serverView;
    private List<Client> clients = new ArrayList<>();
    private ReadFromFile readFromFile;
    private SaveToFile saveToFile;


    public Server(ReadFromFile readFromFile, SaveToFile saveToFile, ServerView serverView) {
        this.readFromFile = readFromFile;
        this.saveToFile = saveToFile;
        this.serverView = serverView;
        this.clients = getClients();
    }

    public boolean isServerStatus() {
        return this.serverStatus;
    }

    public void startServer() {
        if (!this.isServerStatus()) {
            serverView.showTextAllMessagesServer("Server Up !!!" + "\n", this.serverStatus);
        } else {
            serverView.showTextAllMessagesServer("Сервер УЖЕ запущен." + "\n", this.serverStatus);
        }
        this.serverStatus = true;
    }

    public void stopServer() {
        if (isServerStatus()) {
            serverView.showTextAllMessagesServer("Server Down !!!" + "\n", this.serverStatus);
        } else {
            serverView.showTextAllMessagesServer("Сервер НЕ работает." + "\n", this.serverStatus);
        }
        this.serverStatus = false;
    }

    public String findAllTextMessages() {
        List<Message> logArray = readFromFile.readAllFromFile();
        logArray.sort(Comparator.comparing(Message::getDateMessage));
        StringBuilder stringBuilder = new StringBuilder();
        for (Message message : logArray) {
            stringBuilder.append(message.getDateMessage())
                    .append(" ")
                    .append(message.getAuthorMessage())
                    .append(": ")
                    .append(message.getTextMessage())
                    .append("\n");
        }
        return stringBuilder.toString();
    }

    public void showTextAllMessages(String string) {
        serverView.showTextAllMessagesServer(string + "\n", serverStatus);
    }

    public void updateTextAllMessages(String string){
        serverView.updateFieldAllMessages(serverView.findAllTextMessages() + string);
    }

    public void saveMessage(Message message) {
        saveToFile.writeToFile(message);
    }

    public List<Client> getClients() {
        return clients;
    }

    public void addClientToList(Client client) {
        this.clients.add(client);
    }

    public void removeClientFromList(Client client) {
        this.clients.remove(client);
    }

//    private class ThreadUpdater(){
//        public static void main(String[] args) {
//
//            Thread run = new Thread(() -> {
//                while (true) {
//                    try {
//                        for (Client client : clients) {
//                            if(!this.isServerStatus()){
//                                client.setClientStatus(false);
//                            }
//                            client.updateFieldAllMessages();
//                        }
//                        Thread.sleep(1000); //1000 == 1 сек
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            });
//            run.start();
//        }
//    }
}
