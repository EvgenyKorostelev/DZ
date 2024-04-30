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
        String[] toysArr;
        String line;
        try (BufferedReader bfr = new BufferedReader(new FileReader(path))){
            while ((line = bfr.readLine()) != null) {
                toysArr = line.split(";");
                Toy toy = new Toy(Integer.parseInt(toysArr[0]), toysArr[1],
                        Integer.parseInt(toysArr[2]), Float.parseFloat(toysArr[3]));
                toys.add(toy);
            }
        } catch (IOException e) {
            System.out.println("В магазине нет ни одной игрушки.");
        }
        return toys;
    }
}
