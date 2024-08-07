package services;

import entitys.*;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class AddNewAnimal {

    private final IdFactory idFactory = new IdFactory();

    public Animal addAnimal() {
        Animal animal = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Добавление нового животного.");
        System.out.println("выберите вид животного");
        System.out.println("""
                    введите цифру из списка:
                1 - Собака.
                2 - Кошка.
                3 - Хомяк.
                    Ваш выбор:
                """);
        int command = Integer.MAX_VALUE;
        while (command < 1 || command > 3) {
            try {
                command = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Добавление нового животного.");
                System.out.println("""
                            вет такого вида, повторите ввод:
                        1 - Собака.
                        2 - Кошка.
                        3 - Хомяк.
                            Ваш выбор:
                        """);
            }
        }
        Integer kindId = command;
        System.out.println("Добавление нового животного.");
        System.out.println("введите имя животного: ");
        String name = scanner.nextLine();
        System.out.println("Добавление нового животного.");
        System.out.println("введите команды, которым обучено животное(через запятую',' без пробелов): ");
        List<String> commandsAnimal = Arrays.asList(scanner
                .nextLine()
                .replaceAll(" ", "")
                .split(","));
        System.out.println("Добавление нового животного.");
        System.out.println("введите дату рождения животного в формате(гггг-мм-дд): ");
        String dateBirth = "gggg-mm-dd-";
        while (!dateValidator(dateBirth)) {
            dateBirth = scanner.nextLine();
            if (!dateValidator(dateBirth)) {
                System.out.println("Добавление нового животного.");
                System.out.println("""
                            неверный формат повторите ввод
                            в виде (гггг-мм-дд)
                            пример: 1998-07-08
                        """);
            }
        }
        switch (command) {
            case (1):
                try {
                    animal = new Dog(idFactory.createId(), name, commandsAnimal, dateBirth, kindId);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            case (2):
                try {
                    animal = new Cat(idFactory.createId(), name, commandsAnimal, dateBirth, kindId);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            case (3):
                try {
                    animal = new Hamster(idFactory.createId(), name, commandsAnimal, dateBirth, kindId);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
        return animal;
    }

    //Валидация вводимой даты рождения животного
    private boolean dateValidator(String date) {
        DateTimeFormatter dateFormatter = DateTimeFormatter
                .ofPattern("uuuu-MM-dd", Locale.ITALY)
                .withResolverStyle(ResolverStyle.STRICT);
        try {
            dateFormatter.parse(date);
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }
}
