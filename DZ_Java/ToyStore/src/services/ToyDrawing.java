package services;

import entity.Toy;
import repository.SaveToyToFile;

import java.util.*;

public class ToyDrawing {

    public List<Toy> drawing(List<Toy> toys, String pathPrize) {
        List<Toy> toysForDraw = new ArrayList<>(toys);
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
                if (countDraws > countAllToys || countDraws < 1)
                    System.out.println("Количество игрушек, для розыгрыша должно быть" +
                            " больше 0 и меньше " + countAllToys + " повторите ввод: ");
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат, повторите ввод: ");
            }
        }

        List<Toy> prizeToys = new ArrayList<>();
        for (int i = 0; i < countDraws; i++) {
            Toy prizeToy = choicePrizeToy(toysForDraw);
            prizeToys.add(prizeToy);

            for (int j = 0; j < toysForDraw.size(); j++) {
                if (prizeToy.getName().equals(toys.get(j).getName())
                        && toys.get(j).getCount() > 1) {
                    toysForDraw.get(j).setCount(toysForDraw.get(j).getCount() - 1);
                } else if (prizeToy.getName().equals(toys.get(j).getName())
                        && toys.get(j).getCount() == 1) {
                    toysForDraw.remove(toys.get(j));
                }
            }

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
        while (prizeToy == null) {
            float randomNumber = rnd.nextFloat();
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
