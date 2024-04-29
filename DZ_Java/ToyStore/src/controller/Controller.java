package controller;

import entity.Toy;
import repository.FindAllToys;
import repository.SaveToyToFile;
import services.AddNewToy;

import java.util.List;
import java.util.Scanner;

public class Controller {

    public void startApplication() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Добро пожаловать в ToyStore :)");
        System.out.println("""
                Введите команду из списка:
                1 - Добавить игрушку в магазин
                2 - Получить список всех игрушек в магазине
                3 - Изменить шанс выпадения игрушки по названию
                4 - Провести розыгрыш""");
        int command = scanner.nextInt();
        switch (command) {
            case (1):
                AddNewToy adder = new AddNewToy();
                SaveToyToFile saver = new SaveToyToFile();
                saver.save(adder.add(), "storageToys.txt");
                System.out.println("Игрушка добавлена в магазин");

            case (2):
                FindAllToys finder = new FindAllToys();
                List<Toy> allToys = finder.findAll("storageToys.txt");
                for (Toy toy : allToys) {
                    System.out.println(toy);
                }
            case (3):
                System.out.println("Введите название игрушки: ");
                String nameToy = scanner.nextLine();

        }
    }
}
