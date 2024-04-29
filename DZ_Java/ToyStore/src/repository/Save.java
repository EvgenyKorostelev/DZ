package repository;

import entity.Toy;

import java.io.IOException;

public interface Save {
    void save(Toy toy, String path);
}
