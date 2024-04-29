package repository;

import entity.Toy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FindAllToys {

    public List<Toy> findAll(String path){
        List<Toy> toys = new ArrayList<>();
        String[] toyArr;
        String line;
        try (BufferedReader bfr = new BufferedReader(new FileReader(path))){
            while ((line = bfr.readLine()) != null) {
                toyArr = line.split(";");
                Toy toy = new Toy(Integer.parseInt(toyArr[0]), toyArr[1],
                        Integer.parseInt(toyArr[2]), Float.parseFloat(toyArr[3]));
                toys.add(toy);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return toys;
    }
}
