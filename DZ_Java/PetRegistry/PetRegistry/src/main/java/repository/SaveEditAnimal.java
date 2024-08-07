package repository;

import entitys.Animal;
import entitys.Cat;
import entitys.Dog;
import entitys.Hamster;
import repository.db.Const;
import repository.db.DatabaseHandler;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SaveEditAnimal implements SaveAnimal {

    private final DatabaseHandler databaseHandler = new DatabaseHandler();

    @Override
    public void saveAnimalToDb(Animal animal) throws SQLException, ClassNotFoundException {
        PreparedStatement prSt = null;
        String update;
        if (animal instanceof Dog) {
            update = "UPDATE " + Const.DOGS_TABLE + " SET " +
                    Const.DOG_COMMANDS + "=?" +
                    " WHERE " + Const.DOG_NAME + "=?";
            prSt = databaseHandler.getDbConnection().prepareStatement(update);
            prSt.setString(1, String.join(",", ((Dog) animal).getCommands())
                    .replace(" ", ""));
            prSt.setString(2, ((Dog) animal).getName());
        } else if (animal instanceof Cat) {
            update = "UPDATE " + Const.CATS_TABLE + " SET " +
                    Const.CAT_COMMANDS + "=?" +
                    " WHERE " + Const.CAT_NAME + "=?";
            prSt = databaseHandler.getDbConnection().prepareStatement(update);
            prSt.setString(1, String.join(",", ((Cat) animal).getCommands())
                    .replace(" ", ""));
            prSt.setString(2, ((Cat) animal).getName());
        } else if (animal instanceof Hamster) {
            update = "UPDATE " + Const.HAMSTERS_TABLE + " SET " +
                    Const.HAMSTER_COMMANDS + "=?" +
                    " WHERE " + Const.HAMSTER_NAME + "=?";
            prSt = databaseHandler.getDbConnection().prepareStatement(update);
            prSt.setString(1, String.join(",", ((Hamster) animal).getCommands())
                    .replace(" ", ""));
            prSt.setString(2, ((Hamster) animal).getName());
        }
        if (prSt != null) {
            prSt.executeUpdate();
        }
    }
}

