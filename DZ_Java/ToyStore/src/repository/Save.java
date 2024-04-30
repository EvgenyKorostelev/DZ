package repository;

import entity.Toy;

import java.io.IOException;

public interface Save {
    void saveNewToy(Toy toy, String path);
    void saveEditRateToy(Toy toy, String path);
    void saveEditCountToy(Toy toy, String path);
}
