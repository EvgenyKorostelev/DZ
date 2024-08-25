package repository;

import entity.Message;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SaveMessagesToFile implements SaveToFile {

    @Override
    public void writeToFile(Message message) {
        String path = "src/main/resources/log.txt";
        Path file = Paths.get(path);
        if (Files.exists(file)) {
            try (FileWriter writer = new FileWriter(path, true)) {
                writer.append(message.getAuthorMessage()).append(";")
                        .append(message.getTextMessage()).append(";")
                        .append(message.getDateMessage())
                        .append("\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            new File(path);
            writeToFile(message);
        }
    }
}
