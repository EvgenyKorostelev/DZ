package services;

import entity.Toy;
import repository.SaveToyToFile;

import java.util.*;

public class ToyDrawing {

    public void drawing(List<Toy> toys, String pathPrize) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество игрушек, которые хотите разыграть: ");
        int countDraws = scanner.nextInt();
        List<Toy> prizeToys = new ArrayList<>();
        for (int i = 0; i < countDraws; i++) {
            prizeToys.add(choicePrizeToy(toys));
        }
        System.out.println("Вы выйграли следующие игрушки: ");
        receivingPrizeToy(prizeToys, pathPrize);
        for (Toy prizeToy : prizeToys) {
            System.out.println(prizeToy);
        }
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
