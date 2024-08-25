import entity.client.Client;
import entity.client.ClientWindow;
import entity.server.Server;
import entity.server.ServerWindow;
import repository.ReadMessagesAllUsersFromFile;
import repository.SaveMessagesToFile;

import java.util.ArrayList;
import java.util.List;

public class MessagingApplication {
    public static void main(String[] args) {
        ReadMessagesAllUsersFromFile read = new ReadMessagesAllUsersFromFile();
        SaveMessagesToFile save = new SaveMessagesToFile();
        ServerWindow serverWindow = new ServerWindow();
        Server server = new Server(read, save, serverWindow);
        serverWindow.setServer(server);

        ClientWindow clientWindow1 = new ClientWindow();
        ClientWindow clientWindow2 = new ClientWindow();
        Client client1 = new Client();
        Client client2 = new Client();
        clientWindow1.setClient(client1);
        clientWindow2.setClient(client2);
        client1.setServer(server);
        client2.setServer(server);
        client1.setClientView(clientWindow1);
        client2.setClientView(clientWindow2);

        List<Client> clients = new ArrayList<>();
        clients.add(client1);
        clients.add(client2);

        Thread run = new Thread(() -> {
            while (true) {
                try {
                    for (Client client : clients) {
                        if(!server.isServerStatus()){
                            client.setClientStatus(false);
                        }
                        client.updateFieldAllMessages();
                    }
                    Thread.sleep(1000); //1000 == 1 сек
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        run.start();
    }
}
