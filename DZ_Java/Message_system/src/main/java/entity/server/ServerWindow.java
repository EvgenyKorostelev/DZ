package entity.server;

import javax.swing.*;
import java.awt.*;

public class ServerWindow extends JFrame implements ServerView {

    private static final int WIDTH = 640;
    private static final int HEIGHT = 480;

    private JButton buttonStart, buttonStop;
    private JTextArea fieldAllMessages;

    private Server server;

    public ServerWindow() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);

        setTitle("Server");
        setResizable(true);

        fieldAllMessages = new JTextArea();
        JScrollPane spFieldAllMessages = new JScrollPane(fieldAllMessages);
        fieldAllMessages.setLineWrap(true);


        buttonStart = new JButton("Start");
        buttonStart.addActionListener(e -> actionStartServer());

        buttonStop = new JButton("Stop");
        buttonStop.addActionListener(e -> actionStopServer());

        JPanel panelCenter = new JPanel(new GridLayout(1, 1));
        JPanel panelBottom = new JPanel(new GridLayout(1, 2));
        panelCenter.add(spFieldAllMessages);
        panelBottom.add(buttonStart);
        panelBottom.add(buttonStop);

        add(panelCenter, BorderLayout.CENTER);
        add(panelBottom, BorderLayout.SOUTH);
        setVisible(true);
    }

    public void setServer(Server server) {
        this.server = server;
    }

    @Override
    public void actionStartServer() {
        server.startServer();
    }

    @Override
    public void actionStopServer() {
        server.stopServer();
    }

   public JTextArea getFieldAllMessages() {
        return fieldAllMessages;
    }

    @Override
    public String findAllTextMessages(){
        return fieldAllMessages.getText();
    }

    @Override
    public void updateFieldAllMessages(String string) {
        fieldAllMessages.setText(string);
    }

    @Override
    public void showTextAllMessagesServer(String string, boolean serverStatus) {
        StackTraceElement[] methodTrace = Thread.currentThread().getStackTrace();
        if (!serverStatus && methodTrace[2].getMethodName().equals("startServer")) {
            if(this.fieldAllMessages.getText().isEmpty()) {
                fieldAllMessages.setText(string + server.findAllTextMessages());
            } else {
                fieldAllMessages.setText(this.fieldAllMessages.getText() + string);
            }
        } else {
           fieldAllMessages.setText(this.fieldAllMessages.getText() + string);
        }
    }
}
