import entity.client.ClientWindow;
import entity.server.ServerWindow;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ServerWindow server = new ServerWindow();
        List<ClientWindow> clients = new ArrayList<>();
        clients.add(new ClientWindow(server));
        clients.add(new ClientWindow(server));

        Thread run = new Thread(() -> {
            while (true) {
                try {
                    for (ClientWindow client : clients) {
                        if(!server.isServerStatus()){
                            client.setClientStatus(false);
                        }
                        client.generateTextAllMessages(server);
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
