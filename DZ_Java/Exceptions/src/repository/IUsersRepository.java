package repository;

public interface IUsersRepository {

    void saveInCache(String[] user);

    void saveInFile(String[] user);

}
