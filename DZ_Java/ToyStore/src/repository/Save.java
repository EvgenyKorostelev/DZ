package repository;

import entity.Toy;

public interface Save {
    void saveNewToy(Toy toy, String path);
    void saveEditRateToy(Toy toy, String path);

}
