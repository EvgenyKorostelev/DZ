package services;

import entitys.Animal;
import entitys.Cat;
import entitys.Dog;
import entitys.Hamster;

public class GetAllAnimalCommands {

    public void getAllCommands(Animal animal) {
        if (animal instanceof Dog) {
            System.out.println("Собака " + ((Dog) animal).getName() +
                    " обучена командам: " + String.join(",", ((Dog) animal).getCommands()));
        } else if (animal instanceof Cat) {
            System.out.println("Кошка " + ((Cat) animal).getName() +
                    " обучена командам: " + String.join(",", ((Cat) animal).getCommands()));
        } else if (animal instanceof Hamster) {
            System.out.println("Хомяк " + ((Hamster) animal).getName() +
                    " обучена командам: " + String.join(",", ((Hamster) animal).getCommands()));
        }
    }
}
