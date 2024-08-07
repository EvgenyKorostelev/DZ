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
import java.util.Arrays;

public class FindAnimalByName {

    private final DatabaseHandler databaseHandler = new DatabaseHandler();

    public Animal findByName(String typeAnimal, String name) throws SQLException, ClassNotFoundException {
        Animal animal = null;
        PreparedStatement prSt;
        String select;
        ResultSet resSet;
        switch (typeAnimal) {
            case "Dog" -> {
                select = "SELECT * FROM " + Const.DOGS_TABLE +
                        " WHERE " + Const.DOG_NAME + "=?";
                prSt = databaseHandler.getDbConnection().prepareStatement(select);
                prSt.setString(1, name);
                resSet = prSt.executeQuery();
                while (resSet.next()) {
                    animal = new Dog(Integer.parseInt(resSet.getString(1)),
                            resSet.getString(2),
                            Arrays.asList(resSet.getString(3).split(",")),
                            resSet.getString(4),
                            Integer.parseInt(resSet.getString(5)));
                }
            }
            case "Cat" -> {
                select = "SELECT * FROM " + Const.CATS_TABLE +
                        " WHERE " + Const.CAT_NAME + "=?";
                prSt = databaseHandler.getDbConnection().prepareStatement(select);
                prSt.setString(1, name);
                resSet = prSt.executeQuery();
                while (resSet.next()) {
                    animal = new Cat(Integer.parseInt(resSet.getString(1)),
                            resSet.getString(2),
                            Arrays.asList(resSet.getString(3).split(",")),
                            resSet.getString(4),
                            Integer.parseInt(resSet.getString(5)));
                }
            }
            case "Hamster" -> {
                select = "SELECT * FROM " + Const.HAMSTERS_TABLE +
                        " WHERE " + Const.HAMSTER_NAME + "=?";
                prSt = databaseHandler.getDbConnection().prepareStatement(select);
                prSt.setString(1, name);
                resSet = prSt.executeQuery();
                while (resSet.next()) {
                    animal = new Hamster(Integer.parseInt(resSet.getString(1)),
                            resSet.getString(2),
                            Arrays.asList(resSet.getString(3).split(",")),
                            resSet.getString(4),
                            Integer.parseInt(resSet.getString(5)));
                }
            }
        }
        if (animal == null) {
            System.out.println("В реестре нет такого животного.");
        }
        return animal;
    }
}
