package repository;

import entity.Toy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DeleteToyFromFile {

    public void deleteToy(Toy toy, String path) {
        FindAllToys finder = new FindAllToys();
        List<Toy> toysInFile = finder.findAll(path);
        List<Toy> toysForSave = new ArrayList<>(toysInFile);
        SaveToyToFile saveToyToFile = new SaveToyToFile();

        for (int i = 0; i < toysInFile.size(); i++) {
            if (toy.getName().equals(toysInFile.get(i).getName())
                    && toysInFile.get(i).getCount() > 1) {
                toysInFile.get(i).setCount(toysInFile.get(i).getCount() - 1);
            } else if (toy.getName().equals(toysInFile.get(i).getName())
                    && toysInFile.get(i).getCount() == 1) {
                toysInFile.remove(toysInFile.get(i));
            }
        }


        Path file = Paths.get(path);
        try {
            Files.writeString(file, "");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        for (Toy toyI : toysInFile) {
            saveToyToFile.saveNewToy(toyI, path);
        }
    }
}
