package controller;

import mainclasses.*;
import mainclasses.subclasses.baseclasses.BaseClass;
import view.View;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
//для wav файлов
import javax.sound.sampled.*;
import java.io.File;
import java.util.Scanner;


public class Main {
    public static ArrayList<BaseClass> A;
    public static ArrayList<BaseClass> H;
    public static ArrayList<BaseClass> all = new ArrayList<>();
    public static void main(String[] args) {

        A = createTeam(10, "Alliance");
        H = createTeam(10, "Horde");
        all = turnOrder(A, H);

        fight(A, H);

    }
    //Метод создания списка очередности ходов
    public static ArrayList<BaseClass> turnOrder(ArrayList<BaseClass> team1, ArrayList<BaseClass> team2){
        ArrayList<BaseClass> all = new ArrayList<>();
        all.addAll(team1);
        all.addAll(team2);
        all.sort((o1, o2)-> o2.getSpeed() - o1.getSpeed());
        return all;
    }
    //рандом
    protected static Random rnd;
    static {
        rnd = new Random();
    }
    //Метод создания команд
    public static ArrayList<BaseClass> createTeam(int teamSize, String teamName) {
        ArrayList<BaseClass> team = new ArrayList<>();
        int temp = Integer.MAX_VALUE;
        if (teamName.equals("Alliance")) {
            temp = 0;
        } else if (teamName.equals("Horde")) {
            temp = 3;
        }
        int yY = 0;
        while (teamSize > yY++) {
            int r = temp + rnd.nextInt(4);
            switch (r) {
                case 0:
                    team.add(new Crossbowman(1, yY, teamName));
                    break;
                case 1:
                    team.add(new Pikeman(1, yY, teamName));
                    break;
                case 2:
                    team.add(new Monk(1, yY, teamName));
                    break;
                case 3:
                    if(temp == 0) {
                        team.add(new Peasant(1, yY, teamName));
                    }
                    else {
                        team.add(new Peasant(teamSize, yY, teamName));
                    }
                    break;
                case 4:
                    team.add(new Sniper(teamSize, yY, teamName));
                    break;
                case 5:
                    team.add(new Witch(teamSize, yY, teamName));
                    break;
                case 6:
                    team.add(new Rogue(teamSize, yY, teamName));
                    break;

            }

        }
        return team;
    }
    //метод боя
    public static void fight(ArrayList<BaseClass> team1, ArrayList<BaseClass> team2) {
        HashSet<BaseClass> deadAlliance = new HashSet<>();
        HashSet<BaseClass> deadHorde = new HashSet<>();
//        ArrayList<BaseClass> queue = turnOrder(team1, team2);
        Scanner step = new Scanner(System.in);
        ArrayList<String> log = new ArrayList<>();

         System.out.println("""

                                                                                               Да начнется битва !!!
                 """);
        playSound("C:/Users/ddc_s/OneDrive/Рабочий стол/DZ/DZ_Java/Hero_Chess/src/mainclasses/subclasses/baseclasses/sounds/fight.wav");

        while (deadAlliance.size() < all.size() / 2 && deadHorde.size() < all.size() / 2) {
            if (team1.getFirst().getTeam().equals("Alliance") && team2.getFirst().getTeam().equals("Horde")) {
                deadAlliance.removeIf(unit -> !unit.getDie());
                deadHorde.removeIf(unit -> !unit.getDie());
                for(BaseClass unit : team1 ){
                    if(unit.getDie()) deadAlliance.add(unit);
                }
                for(BaseClass unit : team2 ){
                    if(unit.getDie()) deadHorde.add(unit);
                }
                View.view();
                for (String s : log) {
                    System.out.println(s);
                }
                log.clear();
                for (BaseClass unit : all) {
                    if (unit.getTeam().equals("Alliance")) {
                        unit.step(team2, team1);
                    } else if (unit.getTeam().equals("Horde")) {
                        unit.step(team1, team2);
                    }
                    if (!unit.getInfo().isEmpty())
                        log.add(unit.getInfo());
                }
            } else if (team1.getFirst().getTeam().equals("Horde") && team2.getFirst().getTeam().equals("Alliance")) {
                deadAlliance.removeIf(unit -> !unit.getDie());
                deadHorde.removeIf(unit -> !unit.getDie());
                for(BaseClass unit : team1 ){
                    if(unit.getDie()) deadHorde.add(unit);
                }
                for(BaseClass unit : team2 ){
                    if(unit.getDie()) deadAlliance.add(unit);
                }
                View.view();
                for (String s : log) {
                    System.out.println(s);
                }
                log.clear();
                for (BaseClass unit : all) {
                    if (unit.getTeam().equals("Alliance")) {
                        unit.step(team1, team2);
                    }  else if (unit.getTeam().equals("Horde")) {
                        unit.step(team2, team1);
                    }
                    if (!unit.getInfo().isEmpty())
                        log.add(unit.getInfo());
                }
            }
           step.nextLine();
        }
        if(deadAlliance.size() > deadHorde.size()) {
            System.out.println("""

                                                                                               Победила команда ОРДЫ !!!
                 """);
            playSound("C:/Users/ddc_s/OneDrive/Рабочий стол/DZ/DZ_Java/Hero_Chess/src/mainclasses/subclasses/baseclasses/sounds/horde.wav");
        }
        else {
            System.out.println("""

                                                                                               Победила команда АЛЬЯНСА !!!
                 """);
            playSound("C:/Users/ddc_s/OneDrive/Рабочий стол/DZ/DZ_Java/Hero_Chess/src/mainclasses/subclasses/baseclasses/sounds/alliance.wav");
        }
        System.out.println("Потери Альянс:" + deadAlliance);
        System.out.println("Потери Орда:" + deadHorde);
    }

    //Метод воспроизведения wav файлов
    public static void playSound(String soundFileName) {
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File(soundFileName)));
            clip.setFramePosition(0);
            clip.start();
            Thread.sleep(clip.getMicrosecondLength()/1000);
            clip.stop();
            clip.close();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
