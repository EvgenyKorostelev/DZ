package services;

import entity.Toy;

import java.util.Scanner;

public class EditCountToy {

    public Toy editCount(Toy toy){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите новое значение количества " + toy.getName()+ ": ");
        int count = Integer.parseInt(scanner.nextLine());
        toy.setCount(count);
        return toy;
    }
}
