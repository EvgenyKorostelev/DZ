package repository;

import entitys.Animal;

import java.sql.SQLException;

public interface SaveAnimal {

    void saveAnimalToDb(Animal animal) throws SQLException, ClassNotFoundException;

}
