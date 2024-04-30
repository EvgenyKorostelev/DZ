package controller;

import entity.Toy;
import repository.FindAllToys;
import repository.FindToyByName;
import repository.SaveToyToFile;
import services.AddNewToy;
import services.ToyDrawing;

import java.util.List;
import java.util.Scanner;

public class Controller {


    public void startApplication() {
        String pathStore = "storageToys.txt";
        String pathPrizes = "prizeToys.txt";
        FindAllToys finderAll = new FindAllToys();
        SaveToyToFile saver = new SaveToyToFile();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Добро пожаловать в ToyStore :)");
        System.out.println("""
                Введите команду из списка:
                1 - Добавить игрушку в магазин.
                2 - Получить список всех игрушек в магазине.
                3 - Изменить шанс выпадения игрушки по названию.
                4 - Провести розыгрыш.
                """);
        int command = scanner.nextInt();
        switch (command) {

            case (1):
                AddNewToy adder = new AddNewToy();
                saver.saveNewToy(adder.add(), pathStore);
                System.out.println("Игрушка добавлена в магазин.");
                break;
            case (2):
                List<Toy> allToys = finderAll.findAll(pathStore);
                for (Toy toy : allToys) {
                    System.out.println(toy);
                }
                break;
            case (3):
                FindToyByName finderOne = new FindToyByName();
                System.out.println("Введите название игрушки: ");
                String nameToy = scanner.nextLine();
                Toy toy = finderOne.findByName(nameToy, pathStore);
                if (toy == null)
                    System.out.println("В магазине нет такой игрушки.");
                else {
                    saver.saveEditRateToy(toy, pathStore);
                    System.out.println("Шанс выпадения " + toy.getName() + " изменен.");
                }
                break;
            case (4):
                ToyDrawing drawing = new ToyDrawing();
                drawing.drawing(finderAll.findAll(pathStore), pathPrizes);
                System.out.println();
                break;
        }
    }
}
