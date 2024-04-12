package repository;

import entity.User;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;


public class UsersRepository implements IUsersRepository {

    private final List<User> users = new LinkedList<>();

    @Override
    public void saveInCache(String[] user) {
        users.add(new User(user[0],user[1], user[2], user[3],
                Long.parseLong(user[4]), user[5].charAt(0)));
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

}






