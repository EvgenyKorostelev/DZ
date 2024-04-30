package services;

import entity.Toy;

import java.util.Scanner;

public class EditRateToy {

    public Toy editRate(Toy toy) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите новое значение вероятности выпадения(формат 0.55 это 55%): ");

        float rate = -1;
        while (rate <= 0 || rate > 0.99f) {
            try {
                rate = Float.parseFloat(scanner.nextLine());
                if (rate <= 0 || rate > 0.99f)
                    System.out.println("Невалидное значение (должно быть от 0 до 0.99), повторите ввод: ");
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат, повторите ввод: ");
            }
        }
        toy.setRate(rate);
        return toy;
    }
}
