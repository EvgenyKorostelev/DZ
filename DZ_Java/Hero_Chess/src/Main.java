import mainclasses.*;
import mainclasses.subclasses.baseclasses.BaseClass;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
//для wav файлов
import javax.sound.sampled.*;
import java.io.File;

//Что то типа контроллера
public class Main {
    public static void main(String[] args) {
        //проверка createTeam
        ArrayList<BaseClass> A = createTeam(10, "Alliance");
        ArrayList<BaseClass> H = createTeam(10, "Horde");

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

        System.out.println("Да начнется битва !!!");
        playSound("C:/Users/ddc_s/OneDrive/Рабочий стол/DZ/DZ_Java/Hero_Chess/src/mainclasses/subclasses/baseclasses/sounds/fight.wav");

        while (deadAlliance.size() < queue.size() / 2 && deadHorde.size() < queue.size() / 2) {
            if (team1.getFirst().getTeam().equals("Alliance") && team2.getFirst().getTeam().equals("Horde")) {
                for(BaseClass unit : team1 ){
                    if(unit.getDie()) deadAlliance.add(unit);
                }
                for(BaseClass unit : team2 ){
                    if(unit.getDie()) deadHorde.add(unit);
                }
                for (BaseClass unit : queue) {
                    if (unit.getTeam().equals("Alliance")) {
                        unit.step(team2, team1);
                    } else if (unit.getTeam().equals("Horde")) {
                        unit.step(team1, team2);
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
                    if (unit.getTeam().equals("Alliance")) {
                        unit.step(team1, team2);
                    }  else if (unit.getTeam().equals("Horde")) {
                        unit.step(team2, team1);
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
            e.printStackTrace();
        }
    }
}
