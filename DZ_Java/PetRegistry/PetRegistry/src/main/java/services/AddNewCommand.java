package services;

import entitys.Animal;
import entitys.Cat;
import entitys.Dog;
import entitys.Hamster;

import java.util.*;

public class AddNewCommand {

    public Animal addCommand(Animal animal) {
        if (animal != null) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Добавление новых команд животному.");
            System.out.println("введите новые команды(через запятую ',' без пробелов): ");
            List<String> newCommands = Arrays.asList(scanner.nextLine()
                    .replaceAll(" ", "")
                    .split(","));
            Set<String> newAllCommands = new HashSet<>(newCommands);
            if (animal instanceof Dog) {
                newAllCommands.addAll(((Dog) animal).getCommands());
                ((Dog) animal).setCommands(new ArrayList<>(newAllCommands));
            } else if (animal instanceof Cat) {
                newAllCommands.addAll(((Cat) animal).getCommands());
                ((Cat) animal).setCommands(new ArrayList<>(newAllCommands));
            } else if (animal instanceof Hamster) {
                newAllCommands.addAll(((Hamster) animal).getCommands());
                ((Hamster) animal).setCommands(new ArrayList<>(newAllCommands));
            }
        }
        if (animal != null) {
            System.out.println("Команды добавлены.");
        }
        return animal;
    }
}
