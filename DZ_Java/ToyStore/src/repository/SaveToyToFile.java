package repository;

import entity.Toy;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class SaveToyToFile implements Save {

    @Override
    public void save(Toy toy, String path) {//"storageToys.txt", "prizeToys.txt"
        Path file = Paths.get(path);
        FindAllToys finder = new FindAllToys();
        if (Files.exists(file)) {
            List<Toy> toysInFile = finder.findAll(path);
            boolean flag = false;
            for (Toy toyI : toysInFile) {
                if(toy.getName().equals(toyI.getName())){
                    flag =true;
                    toyI.setCount(toyI.getCount() + 1);
                    try {
                        Files.writeString(file, "");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    for (Toy toyJ : toysInFile) {
                        write(toyJ, path);
                    }
                }
            }
            if(!flag) write(toy, path);
        } else {
            new File(path);
            write(toy, path);
        }
    }

    private void write(Toy toy, String path) {
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
