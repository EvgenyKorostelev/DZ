package repository;

import entity.User;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class UsersRepository implements ISave {

    private final List<User> users = new LinkedList<>();

    @Override
    public void saveInCache(String[] user) {

    }

    @Override
    public void saveInFile(String[] user){
        try (FileWriter writer = new FileWriter(user[0]+".txt", true)){
            writer.write("<"+ String.join("><", user) +">\n" );
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveInDataBase(String[] user) {

    }
}






