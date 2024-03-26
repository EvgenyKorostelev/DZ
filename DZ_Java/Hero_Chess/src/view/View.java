package view;

import mainclasses.subclasses.baseclasses.BaseClass;
import controller.Main;

import java.util.Collections;

public class View {
    private static int step = 0;
    private static int l = 0;
    private static final String top10 = formatDiv("a") + String.join("", Collections.nCopies(9, formatDiv("-b"))) + formatDiv("-c");
    private static final String midl10 = formatDiv("d") + String.join("", Collections.nCopies(9, formatDiv("-e"))) + formatDiv("-f");
    private static final String bottom10 = formatDiv("g") + String.join("", Collections.nCopies(9, formatDiv("-h"))) + formatDiv("-i");
    private static void tabSetter(int cnt, int max){
        int dif = max - cnt + 2;
        if (dif>0) System.out.printf("%" + dif + "s", ":\t");
        else System.out.print(":\t");
    }
    //Символы для отрисовки поля
    private static String formatDiv(String str) {
        return str.replace('a', '\u250c')
                .replace('b', '\u252c')
                .replace('c', '\u2510')
                .replace('d', '\u251c')
                .replace('e', '\u253c')
                .replace('f', '\u2524')
                .replace('g', '\u2514')
                .replace('h', '\u2534')
                .replace('i', '\u2518')
                .replace('-', '\u2500');
    }
    //Для отрисовки первого символа класса юнита
    private static String getChar(int x, int y){
        String out = "| ";
        for (BaseClass unit: Main.all) {
            if (unit.getUnitpoint().getCoordinateY() == x && unit.getUnitpoint().getCoordinateX() == y){
                if (unit.getDie()) {
                    out = "|" + (AnsiColors.ANSI_WHITE + unit.toString().charAt(0) + AnsiColors.ANSI_RESET);
                    break;
                }
            }
        }
        for (BaseClass unit: Main.all) {
            if (unit.getUnitpoint().getCoordinateY() == x && unit.getUnitpoint().getCoordinateX() == y){
                if(!unit.getDie()){
                    if (Main.H.contains(unit)) out = "|" + (AnsiColors.ANSI_GREEN + unit.toString().charAt(0) + AnsiColors.ANSI_RESET);
                    if (Main.A.contains(unit)) out = "|" + (AnsiColors.ANSI_BLUE + unit.toString().charAt(0) + AnsiColors.ANSI_RESET);
                    break;
                }
            }
        }
        return out;
    }
    //Логика построения всей картинки
    public static void view() {
        if (step == 0) {System.out.print(AnsiColors.ANSI_YELLOW + "Team placement:" + AnsiColors.ANSI_RESET);}
        else System.out.print(AnsiColors.ANSI_YELLOW + "Step:" + step + AnsiColors.ANSI_RESET);
        step++;
        Main.all.forEach((v) -> l = Math.max(l, v.toString().length()));
        System.out.print(AnsiColors.ANSI_YELLOW + "⌛".repeat(l) + AnsiColors.ANSI_RESET);
        System.out.println();
        System.out.print(top10 + "    ");
        System.out.print(AnsiColors.ANSI_BLUE + "Alliance side" + AnsiColors.ANSI_RESET);
        //for (int i = 0; i < l[0]-9; i++)
        System.out.print(" ".repeat(l-11));
        System.out.println(":" + AnsiColors.ANSI_GREEN + "\tHorde side" + AnsiColors.ANSI_RESET);
        for (int i = 1; i < 11; i++) {
            System.out.print(getChar(1, i));
        }
        System.out.print("|    ");
        System.out.print(Main.A.getFirst());
        tabSetter(Main.A.getFirst().toString().length(), l);
        System.out.println(Main.H.getFirst());
        System.out.println(midl10);

        for (int i = 2; i < 10; i++) {
            for (int j = 1; j < 11; j++) {
                System.out.print(getChar(i, j));
            }
            System.out.print("|    ");
            System.out.print(Main.A.get(i-1));
            tabSetter(Main.A.get(i-1).toString().length(), l);
            System.out.println(Main.H.get(i-1));
            System.out.println(midl10);
        }
        for (int j = 1; j < 11; j++) {
            System.out.print(getChar(10, j));
        }
        System.out.print("|    ");
        System.out.print(Main.A.get(9));
        tabSetter(Main.A.get(9).toString().length(), l);
        System.out.println(Main.H.get(9));
        System.out.println(bottom10);
    }
}