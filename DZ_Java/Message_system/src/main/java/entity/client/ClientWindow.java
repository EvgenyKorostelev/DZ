package entity.client;

import entity.Message;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class ClientWindow extends JFrame implements ClientView {

    private static final int WIDTH = 640;
    private static final int HEIGHT = 480;

    private JTextField fieldIp;
    private JTextField fieldPort;
    private JTextField fieldLogin;
    private JPasswordField fieldPassword;
    private JButton buttonLogin;
    private JTextField fieldMessage;
    private JButton buttonSend;
    private JTextArea fieldAllMessages;

    private Client client;


    public ClientWindow() {

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(WIDTH, HEIGHT);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screenSize.width - 1000) / 2, (screenSize.height - 800) / 2);

        setTitle("Client");
        setResizable(true);

        fieldIp = new JTextField(15);
        fieldPort = new JTextField(4);
        fieldLogin = new JTextField(10);
        fieldPassword = new JPasswordField(8);
        fieldPassword.setEchoChar('*');

        buttonLogin = new JButton("Login");
        buttonLogin.addActionListener(e -> actionLoginClient());

        fieldAllMessages = new JTextArea();
        JScrollPane spFieldAllMessages = new JScrollPane(fieldAllMessages);
        fieldAllMessages.setLineWrap(true);
        fieldAllMessages.setWrapStyleWord(true);

        fieldMessage = new JTextField(50);
        fieldMessage.addActionListener(e ->
                actionSendMessageClient());

        buttonSend = new JButton("Send");
        buttonSend.addActionListener(e ->
                actionSendMessageClient());

        JPanel panelTop = new JPanel(new GridLayout(2, 1));
        JPanel panelTopFirst = new JPanel(new GridLayout(1, 5));
        JPanel panelTopSecond = new JPanel(new GridLayout(1, 5));
        JPanel panelCenter = new JPanel(new GridLayout(1, 1));
        JPanel panelBottom = new JPanel(new GridLayout(1, 2));

        panelTopFirst.add(new JLabel("ip адрес: "));
        panelTopFirst.add(fieldIp);
        panelTopFirst.add(new JLabel("порт: "));
        panelTopFirst.add(fieldPort);
        panelTopFirst.add(new JPanel());

        panelTopSecond.add(new JLabel("логин: "));
        panelTopSecond.add(fieldLogin);
        panelTopSecond.add(new JLabel("пароль: "));
        panelTopSecond.add(fieldPassword);
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

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public void actionLoginClient() {
        client.connectToServer();
    }

    @Override
    public void actionSendMessageClient() {
        client.sendMessage();
        this.fieldMessage.setText("");
    }

    @Override
    public String findAllTextMessages() {
        return fieldAllMessages.getText();
    }

    @Override
    public String findUserLogin() {
        return fieldLogin.getText();
    }

    @Override
    public void showTextAllMessagesClient(String string) {
        fieldAllMessages.setText(string);
    }

    @Override
    public Message generateMessage() {
        return new Message(fieldLogin.getText(), fieldMessage.getText());
    }

    @Override
    protected void processWindowEvent(WindowEvent e) {
        super.processWindowEvent(e);
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            client.setClientStatus(false);
            client.disconnectFromServer();
        }
    }
}
