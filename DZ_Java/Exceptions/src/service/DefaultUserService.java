package service;

import exceptions.NotValidInputException;

import java.util.Scanner;

public class DefaultUserService implements IUserService{

    @Override
    public String[] createUser() {
        System.out.println("Введите данные пользователя через пробел:");
        String[] enteredUser;
        try (Scanner scanner = new Scanner(System.in)) {
            String[] data = scanner.nextLine().split(" ");
            if (data.length != 6) throw new NotValidInputException(data.length);
            else enteredUser = data;
        } catch (NotValidInputException e) {
            if (e.getLength() < 6) System.out.println("Введено данных меньше, чем требуется.");
            else if (e.getLength() > 6) System.out.println("Введено данных больше, чем требуется.");
            throw new RuntimeException(e);
        }
        return enteredUser;
    }

}
