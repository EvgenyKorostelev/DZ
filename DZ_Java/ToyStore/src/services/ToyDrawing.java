package services;

import entity.Toy;
import repository.SaveToyToFile;

import java.util.*;

public class ToyDrawing {

    public List<Toy> drawing(List<Toy> toys, String pathPrize) {
//        List<Toy> toysForDraw = new ArrayList<>(toys);
        int countAllToys = 0;
        for (Toy toy : toys) {
            countAllToys += toy.getCount();
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Сейчас в магазине ВСЕГО " + countAllToys + " игрушек, ");
        System.out.println("введите количество игрушек, которые хотите разыграть: ");
        int countDraws = 0;
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

        Collections.shuffle(toys);

        List<Toy> prizeToys = new ArrayList<>();
        for (int i = 0; i < countDraws; i++) {
            Toy prizeToy = choicePrizeToy(toys);
            prizeToys.add(prizeToy);

            for (int j = 0; j < toys.size(); j++) {
                if (prizeToy.getName().equals(toys.get(j).getName())
                        && toys.get(j).getCount() > 1) {
                    toys.get(j).setCount(toys.get(j).getCount() - 1);
                    break;
                } else if (prizeToy.getName().equals(toys.get(j).getName())
                        && toys.get(j).getCount() == 1) {
                    toys.remove(toys.get(j));
                    break;
                } // каждый раз удаляются все игрушки из списка розыгрыша, исправить !!!
                  // ссылка на объект одна и та же из-за этого choicePrizeToy(35 строка),
                  // делает count 1 у объекта в списке
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
        Toy prizeToy = null;
        Random rnd = new Random();
        while (prizeToy == null) {
            float randomNumber = rnd.nextFloat();
            for (Toy toy : toys) {
                if (randomNumber <= toy.getRate()) {
                    prizeToy = new Toy(toy.getId(), toy.getName(), toy.getCount(), toy.getRate());
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
