import controller.Controller;

import java.util.Scanner;

public class PetRegistryApplication {
    public static void main(String[] args) {
        Controller start = new Controller();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            start.startApplication();
            System.out.println("Введите любой символ для продолжения или 'q' для выхода из приложения: ");
            String value = scanner.next();
            if ("q".equals(value)) {
                System.out.println("Завершение работы программы . . .");
                break;
            }
        }
    }
}
