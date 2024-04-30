package services;

import entity.Toy;
import repository.FindAllToys;
import repository.SaveToyToFile;

import java.util.*;

public class ToyDrawing {

    public List<Toy> drawing(List<Toy> toys, String pathPrize) {
        int countAllToys = 0;
        for (Toy toy : toys) {
            countAllToys += toy.getCount();
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Сейчас в магазине ВСЕГО " + countAllToys + " игрушек, ");
        System.out.println("введите количество игрушек, которые хотите разыграть: ");
        int countDraws = Integer.MAX_VALUE;
        while (countDraws > countAllToys || countDraws < 1) {
            try {
                countDraws = Integer.parseInt(scanner.nextLine());
                if(countDraws > countAllToys || countDraws < 1)
                    System.out.println("Количество игрушек, для розыгрыша должно быть" +
                            " больше 0 и меньше " + countAllToys + " повторите ввод: ");
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат, повторите ввод: ");
            }
        }

        List<Toy> prizeToys = new ArrayList<>();
        for (int i = 0; i < countDraws; i++) {
            prizeToys.add(choicePrizeToy(toys));
        }
        System.out.println("Вы выйграли следующие игрушки: ");
        receivingPrizeToy(prizeToys, pathPrize);
        for (Toy toy : prizeToys) {
            System.out.println(toy);
        }
        return prizeToys;
    }

    private Toy choicePrizeToy(List<Toy> toys) {//выбор призовой игрушки
        Collections.shuffle(toys);
        Toy prizeToy = null;
        Random rnd = new Random();
        float randomNumber = rnd.nextFloat();
        while (prizeToy == null) {
            for (Toy toy : toys) {
                if (randomNumber <= toy.getRate()) {
                    prizeToy = toy;
                    prizeToy.setCount(1);
                    break;
                }
            }
        }
        return prizeToy;
    }

    private void receivingPrizeToy(List<Toy> toys, String pathPrize) {//получение призовой игрушки
        SaveToyToFile receiving = new SaveToyToFile();
        for (Toy toy : toys) {
            receiving.saveNewToy(toy, pathPrize);
        }
    }
}
