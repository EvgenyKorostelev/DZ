package controller;

import mainclasses.*;
import mainclasses.subclasses.baseclasses.BaseClass;
// import view.View;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;




public class Main {
    public  ArrayList<BaseClass> A;
    public  ArrayList<BaseClass> H;
    public  ArrayList<BaseClass> all;
    public  ArrayList<String> log;
    public HashSet<BaseClass> deadAlliance;
    public HashSet<BaseClass> deadHorde;

    public Main(){
        A = createTeam(10, "Alliance");
        H = createTeam(10, "Horde");
        all = turnOrder(A, H);
        log = new ArrayList<>();
        deadAlliance = new HashSet<>();
        deadHorde = new HashSet<>();
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
    public String fight() {
        deadAlliance.removeIf(unit -> !unit.getDie());
        deadHorde.removeIf(unit -> !unit.getDie());
        for(BaseClass unit : A ){
            if(unit.getDie()) deadAlliance.add(unit);
        }
        for(BaseClass unit : H ){
            if(unit.getDie()) deadHorde.add(unit);
        }
        log.clear();

        for (BaseClass unit : all) {
            if (unit.getTeam().equals("Alliance")) {
                unit.step(H, A);
            } else if (unit.getTeam().equals("Horde")) {
                unit.step(A, H);
            }
            if (!unit.getInfo().isEmpty())
                log.add(unit.getInfo());
        }
        for (String s : log) {
            System.out.println(s);
        }
        System.out.println();
        if(deadAlliance.size() == all.size() / 2  & deadAlliance.size() > deadHorde.size()) {
            return"Победила команда ОРДЫ !!!";

        }
        else if (deadHorde.size() == all.size() / 2 & deadAlliance.size() < deadHorde.size()){
            return"Победила команда АЛЬЯНСА !!!";
        }
        return null;
    }
}
