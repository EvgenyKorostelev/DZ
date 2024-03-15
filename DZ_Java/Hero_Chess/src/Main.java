import mainclasses.*;
import mainclasses.subclasses.HealClass;
import mainclasses.subclasses.MeleeClass;
import mainclasses.subclasses.RangeClass;
import mainclasses.subclasses.WorkersClass;
import mainclasses.subclasses.baseclasses.BaseClass;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

import javax.sound.sampled.*;
import java.io.File;


public class Main {
    public static void main(String[] args) {
        //проверка createTeam
        ArrayList<BaseClass> A = createTeam(10, "Alliance");
        ArrayList<BaseClass> H = createTeam(10, "Horde");
//        System.out.println(A);
//        System.out.println(H);
//        System.out.println(A.getFirst().getTeam());
//        System.out.println(H.getFirst().getTeam());
//        System.out.println("=====================================================");
//        //проверка findTarget
//        System.out.println(A.get(5));
//        System.out.println("Ближайший враг: "+A.get(5).findTarget(H));
//        System.out.println("=====================================================");
//        //проверка step
//        Sniper sniper = new Sniper();
//        System.out.println(sniper.getArrows());
//        System.out.println(sniper.findTarget(H).getHealth());
//        sniper.step(H);
//        System.out.println(sniper.getArrows());
//        System.out.println(sniper.findTarget(H).getHealth());
//        System.out.println("=====================================================");
//        //проверка turnOrder
//        turnOrder(A, H).forEach(i -> System.out.println(i + " " + i.getSpeed()));
//        System.out.println("=====================================================");
//        // проверка return arrow
//        Peasant psn = new Peasant();
//        Sniper snp = new Sniper();
//        ArrayList<BaseClass> temp = new ArrayList<>();
//        ArrayList<BaseClass> temp2 = new ArrayList<>();
//        temp.add(snp);
//        temp2.add(psn);
//        temp.getFirst().step(temp2);
//        System.out.println(snp.getArrows());
//        psn.returnArrows(temp.getFirst());
//        System.out.println(snp.getArrows());
//        System.out.println("=====================================================");

        fight(A, H);




    }
    //метод создания списка очередности ходов
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
    //метод создания команд
    public static ArrayList<BaseClass> createTeam(int count, String str) {
        ArrayList<BaseClass> team = new ArrayList<>();
        int temp = Integer.MAX_VALUE;
        if (str.equals("Alliance")) {
            temp = 0;
        } else if (str.equals("Horde")) {
            temp = 3;
        }
        while (--count >= 0) {
            int r = temp + rnd.nextInt(4);
            switch (r) {
                case 0:
                    team.add(new Crossbowman(0, count, str));
                    break;
                case 1:
                    team.add(new Pikeman(0, count, str));
                    break;
                case 2:
                    team.add(new Witch(0, count, str));
                    break;
                case 3:
                    if(temp == 0) {
                        team.add(new Peasant(0, count, str));
                    }
                    else if (temp == 3) {
                        team.add(new Peasant(9, count, str));
                    }
                    break;
                case 4:
                    team.add(new Sniper(9, count, str));
                    break;
                case 5:
                    team.add(new Monk(9, count, str));
                    break;
                case 6:
                    team.add(new Rogue(9, count, str));
                    break;

            }

        }
        return team;
    }
    //метод боя
    public static void fight(ArrayList<BaseClass> team1, ArrayList<BaseClass> team2){
        HashSet<BaseClass> deadAlliance = new HashSet<>();
        HashSet<BaseClass> deadHorde = new HashSet<>();
        ArrayList<BaseClass> queue = turnOrder(team1, team2);

        while (deadAlliance.size() < queue.size() / 2 && deadHorde.size() < queue.size() / 2) {
            if (team1.getFirst().getTeam().equals("Alliance") && team2.getFirst().getTeam().equals("Horde")) {
                for(BaseClass unit : team1 ){
                    if(unit.getDie()) deadAlliance.add(unit);
                }
                for(BaseClass unit : team2 ){
                    if(unit.getDie()) deadHorde.add(unit);
                }
                for (BaseClass unit : queue) {
                    if (unit.getTeam().equals("Alliance") && (RangeClass.class.isAssignableFrom(unit.getClass()) || MeleeClass.class.isAssignableFrom(unit.getClass()))) {
                        unit.step(team2);
                    } else if (unit.getTeam().equals("Alliance") && (HealClass.class.isAssignableFrom(unit.getClass()) || WorkersClass.class.isAssignableFrom(unit.getClass()))) {
                        unit.step(team1);
                    } else if (unit.getTeam().equals("Horde") && (RangeClass.class.isAssignableFrom(unit.getClass()) || MeleeClass.class.isAssignableFrom(unit.getClass()))) {
                        unit.step(team1);
                    } else if (unit.getTeam().equals("Horde") && (HealClass.class.isAssignableFrom(unit.getClass()) || WorkersClass.class.isAssignableFrom(unit.getClass()))) {
                        unit.step(team2);
                    }
                }

            } else if (team1.getFirst().getTeam().equals("Horde") && team2.getFirst().getTeam().equals("Alliance")) {
                for(BaseClass unit : team1 ){
                    if(unit.getDie()) deadHorde.add(unit);
                }
                for(BaseClass unit : team2 ){
                    if(unit.getDie()) deadAlliance.add(unit);
                }
                for (BaseClass unit : queue) {
                    if (unit.getTeam().equals("Alliance") && (RangeClass.class.isAssignableFrom(unit.getClass()) || MeleeClass.class.isAssignableFrom(unit.getClass()))) {
                        unit.step(team1);
                    } else if (unit.getTeam().equals("Alliance") && (HealClass.class.isAssignableFrom(unit.getClass()) || WorkersClass.class.isAssignableFrom(unit.getClass()))) {
                        unit.step(team2);
                    } else if (unit.getTeam().equals("Horde") && (RangeClass.class.isAssignableFrom(unit.getClass()) || MeleeClass.class.isAssignableFrom(unit.getClass()))) {
                        unit.step(team2);
                    } else if (unit.getTeam().equals("Horde") && (HealClass.class.isAssignableFrom(unit.getClass()) || WorkersClass.class.isAssignableFrom(unit.getClass()))) {
                        unit.step(team1);
                    }
                }
            }
        }
        if(deadAlliance.size() > deadHorde.size()) {
            System.out.println("Победила команда ОРДЫ !!!");
            playSound("C:/Users/ddc_s/OneDrive/Рабочий стол/DZ/DZ_Java/Hero_Chess/src/mainclasses/subclasses/baseclasses/sounds/horde.wav");
        }
        else {
            System.out.println("Победила команда АЛЬЯНСА !!!");
            playSound("C:/Users/ddc_s/OneDrive/Рабочий стол/DZ/DZ_Java/Hero_Chess/src/mainclasses/subclasses/baseclasses/sounds/alliance.wav");
        }

        System.out.println(deadAlliance);
        System.out.println(deadHorde);
    }


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
            e.printStackTrace();
        }
    }
}
