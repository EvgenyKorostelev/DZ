package controller;

import repository.*;
import services.AddNewAnimal;
import services.AddNewCommand;
import services.GetAllAnimalCommands;

import java.sql.SQLException;
import java.util.Scanner;

public class Controller {

    private final AddNewAnimal addNewAnimal = new AddNewAnimal();
    private final SaveNewAnimal saveNewAnimal = new SaveNewAnimal();
    private final SaveEditAnimal saveEditAnimal = new SaveEditAnimal();
    private final FindAllAnimals findAllAnimals = new FindAllAnimals();
    private final FindAnimalByName findAnimalByName = new FindAnimalByName();
    private final GetAllAnimalCommands getAllAnimalCommands = new GetAllAnimalCommands();
    private final AddNewCommand addNewCommand = new AddNewCommand();
    private final DeleteAnimal deleteAnimal = new DeleteAnimal();


    public void startApplication() {

        Scanner scanner = new Scanner(System.in);
        String name;
        System.out.println("Реестр домашних животных.");
        System.out.println("""
                    введите команду из списка:
                1 - Добавить животное.
                2 - Получить список всех животных в реестре.
                3 - Получить список всех команд животного.
                4 - Добавить новую команду животному.
                5 - Удалить животное из реестра.
                    Ваш выбор:
                """);

        int command = Integer.MAX_VALUE;
        while (command < 1 || command > 5) {
            try {
                command = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("""
                            Нет такой команды, повторите ввод:
                        1 - Добавить животное.
                        2 - Получить список всех животных в реестр.
                        3 - Получить список всех команд животного.
                        4 - Добавить новую команду животному.
                        5 - Удалить животное из реестра.
                            Ваш выбор:
                        """);
            }
        }
        switch (command) {

            case (1)://Добавить животное
                try {
                    saveNewAnimal.saveAnimalToDb(addNewAnimal.addAnimal());
                    System.out.println("Животное добавлено.");
                } catch (SQLException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                break;

            case (2)://Получить список всех животных в реестр
                try {
                    findAllAnimals.findAll().forEach(System.out::println);
                } catch (SQLException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                break;

            case (3)://Получить список всех команд животного
                System.out.println("Получение списка команд животного.");
                System.out.println("""
                            ведите вид животного из списка:
                        1 - Собака.
                        2 - Кошка.
                        3 - Хомяк.
                            Ваш выбор:
                        """);
                int command1 = Integer.MAX_VALUE;
                while (command1 < 1 || command1 > 3) {
                    try {
                        command1 = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Получение списка команд животного.");
                        System.out.println("""
                                    нет такого вида, повторите ввод:
                                1 - Собака.
                                2 - Кошка.
                                3 - Хомяк.
                                    Ваш выбор:
                                """);
                    }
                }
                System.out.println("Получение списка команд животного.");
                System.out.println("введите имя животного: ");
                name = scanner.nextLine();
                switch (command1) {
                    case (1):
                        try {
                            getAllAnimalCommands.getAllCommands(findAnimalByName
                                    .findByName("Dog", name));
                        } catch (SQLException | ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case (2):
                        try {
                            getAllAnimalCommands.getAllCommands(findAnimalByName
                                    .findByName("Cat", name));
                        } catch (SQLException | ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case (3):
                        try {
                            getAllAnimalCommands.getAllCommands(findAnimalByName
                                    .findByName("Hamster", name));
                        } catch (SQLException | ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                }
                break;

            case (4)://Добавить новую команду животному
                System.out.println("Добавление команды животному.");
                System.out.println("""
                            ведите вид животного из списка:
                        1 - Собака.
                        2 - Кошка.
                        3 - Хомяк.
                            Ваш выбор:
                        """);

                int command2 = Integer.MAX_VALUE;
                while (command2 < 1 || command2 > 3) {
                    try {
                        command2 = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Добавление команды животному.");
                        System.out.println("""
                                    нет такого вида, повторите ввод:
                                1 - Собака.
                                2 - Кошка.
                                3 - Хомяк.
                                    Ваш выбор:
                                """);
                    }
                }
                System.out.println("Добавление команды животному.");
                System.out.println("введите имя животного: ");
                name = scanner.nextLine();
                switch (command2) {
                    case (1):
                        try {
                            saveEditAnimal.saveAnimalToDb(addNewCommand.addCommand(findAnimalByName
                                    .findByName("Dog", name)));
                        } catch (SQLException | ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case (2):
                        try {
                            saveEditAnimal.saveAnimalToDb(addNewCommand.addCommand(findAnimalByName
                                    .findByName("Cat", name)));
                        } catch (SQLException | ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case (3):
                        try {
                            saveEditAnimal.saveAnimalToDb(addNewCommand.addCommand(findAnimalByName
                                    .findByName("Hamster", name)));
                        } catch (SQLException | ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                }
                break;

            case (5)://Удалить животное из реестра
                System.out.println("УДАЛЕНИЕ животного из реестра.");
                System.out.println("""
                            ведите вид животного из списка:
                        1 - Собака.
                        2 - Кошка.
                        3 - Хомяк.
                            Ваш выбор:
                        """);
                int command3 = Integer.MAX_VALUE;
                while (command3 < 1 || command3 > 3) {
                    try {
                        command3 = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("УДАЛЕНИЕ животного из реестра.");
                        System.out.println("""
                                    нет такого вида, повторите ввод:
                                1 - Собака.
                                2 - Кошка.
                                3 - Хомяк.
                                    Ваш выбор:
                                """);
                    }
                }
                System.out.println("УДАЛЕНИЕ животного из реестра.");
                System.out.println("введите имя животного: ");
                name = scanner.nextLine();
                switch (command3) {
                    case (1):
                        try {
                            deleteAnimal.deleteAnimalByName(findAnimalByName
                                    .findByName("Dog", name));
                        } catch (SQLException | ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case (2):
                        try {
                            deleteAnimal.deleteAnimalByName(findAnimalByName
                                    .findByName("Cat", name));
                        } catch (SQLException | ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case (3):
                        try {
                            deleteAnimal.deleteAnimalByName(findAnimalByName
                                    .findByName("Hamster", name));
                        } catch (SQLException | ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                }
                break;
        }
    }
}
