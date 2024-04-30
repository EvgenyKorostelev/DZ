package repository;

import entity.Toy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FindToyByName {

    public Toy findByName(String name, String path) {
        String[] toysArr;
        String line;
        try (BufferedReader bfr = new BufferedReader(new FileReader(path))) {
            while ((line = bfr.readLine()) != null) {
                toysArr = line.split(";");
                if (toysArr[1].equals(name)) {
                    Toy toy = new Toy(Integer.parseInt(toysArr[0]), toysArr[1],
                            Integer.parseInt(toysArr[2]), Float.parseFloat(toysArr[3]));
                    return toy;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
