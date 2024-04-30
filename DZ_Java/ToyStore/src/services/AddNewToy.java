package services;

import entity.IdFactory;
import entity.Toy;


import java.io.IOException;
import java.util.Scanner;


public class AddNewToy {

    public Toy add(){
        IdFactory newId = new IdFactory();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название новой игрушки: ");
        String name = scanner.nextLine();
        System.out.println("Введите количество игрушек в шт. ( 5 это 5 штук)");
        int count = -1;
        while (count == -1) {
            try {
                count = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат, повторите ввод: ");
            }
        }
        System.out.println("Введите вероятность выпадения новой игрушки в процентах (формат 0.55 это 55%): ");
        float rate = -1.0f;
        while (rate == -1.0f) {
            try {
                rate = Float.parseFloat(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат, повторите ввод: ");
            }
        }
        try {
            return new Toy(newId.createId(), name, count, rate);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
