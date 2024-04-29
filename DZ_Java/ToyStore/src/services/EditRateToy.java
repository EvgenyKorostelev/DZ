package services;

import entity.Toy;

import java.util.Scanner;

public class EditRateToy {

    public Toy editRate(Toy toy){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите новое значение вероятности выпадения(формат 0.55 это 55%): ");
        float rate = Float.parseFloat(scanner.nextLine());
        toy.setRate(rate);
        return toy;
    }
}
