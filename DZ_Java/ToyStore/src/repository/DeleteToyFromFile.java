package repository;

import entity.Toy;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class DeleteToyFromFile {

    public void deleteToy(Toy toy, String path){
        FindAllToys finder = new FindAllToys();
        List<Toy> toysInFile = finder.findAll(path);
        SaveToyToFile saveToyToFile = new SaveToyToFile();
        for (Toy toyI : toysInFile) {
            if(toy.getName().equals(toyI.getName()) && toyI.getCount() > 1){
                toyI.setCount(toyI.getCount() - 1);
            } else if (toy.getName().equals(toyI.getName()) && toyI.getCount() == 1) {
                toysInFile.remove(toyI);
            }
        }
//        try {
//            Files.writeString(file, "");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        for (Toy toyJ : toysInFile) {
            saveToyToFile.save(toyJ, path);
        }
    }
}
