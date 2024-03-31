package repository;

public interface ISave {

    void saveInCache(String[] user);

    void saveInFile(String[] user);

    void saveInDataBase(String[] user);

}
