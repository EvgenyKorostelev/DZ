package repository;

import entitys.Animal;
import entitys.Cat;
import entitys.Dog;
import entitys.Hamster;
import repository.db.Const;
import repository.db.DatabaseHandler;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnimals {

    private final DatabaseHandler databaseHandler = new DatabaseHandler();

    public List<Animal> findAll() throws SQLException, ClassNotFoundException {
        PreparedStatement prSt;
        ResultSet resSet;
        Animal animal;
        List<Animal> allAnimals = new ArrayList<>();
        String select = "SELECT * FROM " + Const.DOGS_TABLE;
        String select1 = "SELECT * FROM " + Const.CATS_TABLE;
        String select2 = "SELECT * FROM " + Const.HAMSTERS_TABLE;
        prSt = databaseHandler.getDbConnection().prepareStatement(select);
        resSet = prSt.executeQuery();
        while (resSet.next()) {
            animal = new Dog(resSet.getInt(1),
                    resSet.getString(2),
                    Arrays.asList(resSet.getString(3).split(",")),
                    resSet.getString(4),
                    resSet.getInt(5));
            allAnimals.add(animal);
        }
        prSt = databaseHandler.getDbConnection().prepareStatement(select1);
        resSet = prSt.executeQuery();
        while (resSet.next()) {
            animal = new Cat(resSet.getInt(1),
                    resSet.getString(2),
                    Arrays.asList(resSet.getString(3).split(",")),
                    resSet.getString(4),
                    resSet.getInt(5));
            allAnimals.add(animal);
        }
        prSt = databaseHandler.getDbConnection().prepareStatement(select2);
        resSet = prSt.executeQuery();
        while (resSet.next()) {
            animal = new Hamster(resSet.getInt(1),
                    resSet.getString(2),
                    Arrays.asList(resSet.getString(3).split(",")),
                    resSet.getString(4),
                    resSet.getInt(5));
            allAnimals.add(animal);
        }
        return allAnimals;
    }
}
