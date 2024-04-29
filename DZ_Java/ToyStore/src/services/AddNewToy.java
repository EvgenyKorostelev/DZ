package services;

import entity.IdFactory;
import entity.Toy;


import java.io.IOException;
import java.util.Scanner;


public class AddNewToy {

    public Toy add() throws IOException {
        IdFactory newId = new IdFactory();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название новой игрушки: ");
        String name = scanner.nextLine();
        System.out.println("Введите вероятность выпадения новой игрушки в процентах (формат 0.55 это 55%): ");
        float rate = Float.parseFloat(scanner.nextLine());
        return new Toy(newId.createId(), name, 1, rate);
    }

}
