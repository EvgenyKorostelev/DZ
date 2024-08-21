package repository;

import entity.Message;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadMessagesByUserFromFile {

    public List<Message> readFromFileByLogin(String loginUser) {
        String path = "src/main/resources/log.txt";
        List<Message> log = new ArrayList<>();
        String[] messages;
        String line;
        try (BufferedReader bfr = new BufferedReader(new FileReader(path))) {
            while ((line = bfr.readLine()) != null) {
                messages = line.split(";");
                if (messages[0].equals(loginUser)) {
                    log.add(new Message(messages[0], messages[1]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return log;
    }
}
