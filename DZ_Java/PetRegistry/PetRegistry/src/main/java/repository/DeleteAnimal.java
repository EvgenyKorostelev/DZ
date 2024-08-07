package repository;

import entitys.Animal;
import entitys.Cat;
import entitys.Dog;
import entitys.Hamster;
import repository.db.Const;
import repository.db.DatabaseHandler;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteAnimal {

    private final DatabaseHandler databaseHandler = new DatabaseHandler();

    public void deleteAnimalByName(Animal animal) throws SQLException, ClassNotFoundException {
        PreparedStatement prSt;
        String delete;
        if (animal instanceof Dog) {
            delete = "DELETE  FROM " + Const.DOGS_TABLE + " WHERE " + Const.DOG_ID + "=?";
            prSt = databaseHandler.getDbConnection().prepareStatement(delete);
            prSt.setString(1, String.valueOf(((Dog) animal).getId()));
            prSt.executeUpdate();
        } else if (animal instanceof Cat) {
            delete = "DELETE  FROM " + Const.CATS_TABLE + " WHERE " + Const.CAT_ID + "=?";
            prSt = databaseHandler.getDbConnection().prepareStatement(delete);
            prSt.setString(1, String.valueOf(((Cat) animal).getId()));
            prSt.executeUpdate();
        } else if (animal instanceof Hamster) {
            delete = "DELETE  FROM " + Const.HAMSTERS_TABLE + " WHERE " + Const.HAMSTER_ID + "=?";
            prSt = databaseHandler.getDbConnection().prepareStatement(delete);
            prSt.setString(1, String.valueOf(((Hamster) animal).getId()));
            prSt.executeUpdate();
        }
        if (animal != null) {
            System.out.println("Животное удалено из реестра.");
        }
    }
}
