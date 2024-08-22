package entity.server;

import entity.Message;
import repository.ReadMessagesAllUsersFromFile;
import repository.SaveMessagesToFile;

import javax.swing.*;
import java.awt.*;
import java.util.Comparator;
import java.util.List;

public class ServerWindow extends JFrame {

    private static final int WIDTH = 640;
    private static final int HEIGHT = 480;
    private final ReadMessagesAllUsersFromFile readerAllUsers = new ReadMessagesAllUsersFromFile();

    private boolean serverStatus;
    private JButton buttonStart, buttonStop;
    private JTextArea fieldAllMessages;

    public ServerWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);

        setTitle("Message Server");
        setResizable(true);

        fieldAllMessages = new JTextArea();
        JScrollPane spFieldAllMessages = new JScrollPane(fieldAllMessages);
        fieldAllMessages.setLineWrap(true);


        buttonStart = new JButton("Start");
        buttonStop = new JButton("Stop");

        buttonStart.addActionListener(e -> {
            if (!isServerStatus()) {
                fieldAllMessages.setText("Server Up !!!" + "\n"
                        + findMessagesAllUsers());
            } else {
                fieldAllMessages.setText(fieldAllMessages.getText()
                        + "Сервер уже запущен." + "\n");
            }
            serverStatus = true;
        });

        buttonStop.addActionListener(e -> {
            if (isServerStatus()) {
                fieldAllMessages.setText(fieldAllMessages.getText()
                        + "Server Down !!!" + "\n");
            } else {
                fieldAllMessages.setText(fieldAllMessages.getText()
                        + "Сервер НЕ запущен." + "\n");
            }
            serverStatus = false;
        });

        JPanel panelCenter = new JPanel(new GridLayout(1, 1));
        JPanel panelBottom = new JPanel(new GridLayout(1, 2));
        panelCenter.add(spFieldAllMessages);
        panelBottom.add(buttonStart);
        panelBottom.add(buttonStop);

        add(panelCenter, BorderLayout.CENTER);
        add(panelBottom, BorderLayout.SOUTH);
        setVisible(true);
    }

    public boolean isServerStatus() {
        return serverStatus;
    }

    public void saveMessage(Message message) {
        SaveMessagesToFile.writeToFile(message);
    }

    public String findMessagesAllUsers() {
        List<Message> logArray = readerAllUsers.readAllFromFile();
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

    public JTextArea getFieldAllMessages() {
        return fieldAllMessages;
    }

    public void setFieldAllMessages(String string) {
        fieldAllMessages.setText(string);
    }
//    public String findMessagesByUser(String loginUser) {
//        List<Message> log = readerByUser.readFromFileByLogin(loginUser);
//        log.sort(Comparator.comparing(Message::getDate));
//        for (Message message : log) {
//            System.out.println("*************");
//        }
//        return null;
//    }
}
