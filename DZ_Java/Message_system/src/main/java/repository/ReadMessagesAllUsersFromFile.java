package repository;

import entity.Message;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadMessagesAllUsersFromFile {
    public List<Message> readAllFromFile() {
        String path = "src/main/resources/log.txt";
        List<Message> log = new ArrayList<>();
        String[] messages;
        String line;
        try (BufferedReader bfr = new BufferedReader(new FileReader(path))) {
            while ((line = bfr.readLine()) != null) {
                messages = line.split(";");
                log.add(new Message(messages[0], messages[1], messages[2]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return log;
    }
}
