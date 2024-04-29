package repository;

import entity.Toy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SaveToyToFile implements Save {

    @Override
    public void save(Toy toy, String path){//"storageToys.txt", "prizeToys.txt"
        Path file = Paths.get(path);
        if(Files.exists(file)){
            write(toy, path);
        } else {
            new File(path);
            write(toy, path);
        }
//
//        try (FileWriter writer = new FileWriter("toys.txt", true)) {
//            writer.append(String.valueOf(toy.getId())).append(";")
//                    .append(toy.getName()).append(";")
//                    .append(String.valueOf(toy.getCount())).append(";")
//                    .append(String.valueOf(toy.getRate()))
//                    .append("\n");
//        } catch (FileNotFoundException exception) {
//            File file = new File("toys.txt");
//            try (FileWriter writer = new FileWriter("toys.txt", true)) {
//                writer.append(String.valueOf(toy.getId())).append(";")
//                        .append(toy.getName()).append(";")
//                        .append(String.valueOf(toy.getCount())).append(";")
//                        .append(String.valueOf(toy.getRate()))
//                        .append("\n");
//            }
//        }
    }

    private void write(Toy toy, String path){
        try (FileWriter writer = new FileWriter(path, true)) {
            writer.append(String.valueOf(toy.getId())).append(";")
                    .append(toy.getName()).append(";")
                    .append(String.valueOf(toy.getCount())).append(";")
                    .append(String.valueOf(toy.getRate()))
                    .append("\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
