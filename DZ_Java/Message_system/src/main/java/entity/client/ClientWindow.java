package entity.client;

import entity.IdFactory;
import entity.Message;
import entity.server.ServerWindow;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ClientWindow extends JFrame {

    private static final int WIDTH = 640;
    private static final int HEIGHT = 480;
    private final IdFactory idFactory = new IdFactory();

    private boolean clientStatus;
    private Message message;
    private JTextField ipServer;
    private JTextField portServer;
    private JTextField loginUser;
    private String user;
    private JPasswordField passwordUser;
    private JButton buttonLogin;
    private JTextField fieldMessage;
    private JButton buttonSend;
    private JTextArea fieldAllMessages;
    private int clientId;


    public ClientWindow(ServerWindow serverWindow) {
        try {
            clientId = idFactory.createId();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(WIDTH, HEIGHT);

        Dimension screenSize = Toolkit.getDefaultToolkit ().getScreenSize ();
        setLocation((screenSize.width-1000)/2, (screenSize.height-800)/2);
        //setLocationRelativeTo(null);

        clientStatus = false;

        setTitle("Message Client");
        setResizable(true);

        ipServer = new JTextField(15);
        portServer = new JTextField(4);
        loginUser = new JTextField(10);
        passwordUser = new JPasswordField(8);
        passwordUser.setEchoChar('*');

        buttonLogin = new JButton("Login");
        buttonLogin.addActionListener(e -> {
            if (serverWindow.isServerStatus() && !loginUser.getText().isEmpty()) {
                user = loginUser.getText();
                generateTextAllMessages(serverWindow);
                clientStatus = true;
                serverWindow.setFieldAllMessages(serverWindow.getFieldAllMessages().getText()
                        + "Пользователь " + loginUser.getText()
                        + " присоединился к серверу" + "\n");
            } else if (!serverWindow.isServerStatus()) {
                fieldAllMessages.setText(fieldAllMessages.getText()
                        + "Сервер недоступен Connection Failed !!!" + "\n");
            } else if (serverWindow.isServerStatus() && loginUser.getText().isEmpty()) {
                fieldAllMessages.setText(fieldAllMessages.getText()
                        + "Заполните поле Login." + "\n");
            }
        });

        fieldAllMessages = new JTextArea();
        JScrollPane spFieldAllMessages = new JScrollPane(fieldAllMessages);
        fieldAllMessages.setLineWrap(true);
        fieldAllMessages.setWrapStyleWord(true);

        fieldMessage = new JTextField(50);
        fieldMessage.addActionListener(e -> actionSend(serverWindow));

        buttonSend = new JButton("Send");
        buttonSend.addActionListener(e -> actionSend(serverWindow));

        JPanel panelTop = new JPanel(new GridLayout(2, 1));
        JPanel panelTopFirst = new JPanel(new GridLayout(1, 4));
        JPanel panelTopSecond = new JPanel(new GridLayout(1, 5));
        JPanel panelCenter = new JPanel(new GridLayout(1, 1));
        JPanel panelBottom = new JPanel(new GridLayout(1, 2));

        panelTopFirst.add(new JLabel("ip адрес: "));
        panelTopFirst.add(ipServer);
        panelTopFirst.add(new JLabel("порт: "));
        panelTopFirst.add(portServer);

        panelTopSecond.add(new JLabel("логин: "));
        panelTopSecond.add(loginUser);
        panelTopSecond.add(new JLabel("пароль: "));
        panelTopSecond.add(passwordUser);
        panelTopSecond.add(buttonLogin);

        panelTop.add(panelTopFirst);
        panelTop.add(panelTopSecond);
        panelCenter.add(spFieldAllMessages);
        panelBottom.add(fieldMessage);
        panelBottom.add(buttonSend);

        add(panelTop, BorderLayout.NORTH);
        add(panelCenter, BorderLayout.CENTER);
        add(panelBottom, BorderLayout.SOUTH);
        setVisible(true);
    }

    public boolean isClientStatus() {
        return clientStatus;
    }

    public void setClientStatus(boolean clientStatus) {
        this.clientStatus = clientStatus;
    }

    public void postMessage(Message msg, ServerWindow serverWindow) {
        if (!message.getTextMessage().isEmpty() && message.getUserLogin().equals(user)) {
            serverWindow.saveMessage(msg);
        }
    }

    private String generateTextMessage(Message message) {
        return message.getDate() + " "
                + message.getUserLogin() + ": "
                + message.getTextMessage() + "\n";
    }

    public void generateTextAllMessages(ServerWindow serverWindow) {
        if (serverWindow.isServerStatus() && clientStatus) {
            fieldAllMessages.setText(
                    "Connection OK !!!"
                            + "\n" + serverWindow.findMessagesAllUsers());
        }
    }

    private void actionSend(ServerWindow serverWindow) {
        if (serverWindow.isServerStatus() && isClientStatus()) {
            message = new Message(loginUser.getText(),
                    fieldMessage.getText());
            postMessage(message, serverWindow);
            generateTextAllMessages(serverWindow);
            if (!message.getTextMessage().isEmpty() && message.getUserLogin().equals(user)) {
                serverWindow.setFieldAllMessages(serverWindow.getFieldAllMessages().getText()
                        + generateTextMessage(message));
                fieldMessage.setText("");
            }
        } else {
            fieldAllMessages.setText(fieldAllMessages.getText() +
                    "Нет соединения сервером, нажмите кнопку Login" + "\n");
        }
    }
}
