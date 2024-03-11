import mainclasses.*;
import mainclasses.subclasses.baseclasses.BaseClass;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<BaseClass> team1 = new ArrayList<>();
        List<BaseClass> team2 = new ArrayList<>();

        team1.add(new Peasant());
        team2.add(new Peasant());
        team1.add(new Sniper());
        team2.add(new Crossbowman());
        team2.add(new Pikeman());
        team1.add(new Rogue());
        team2.add(new Monk());
        team1.add(new Witch());

        System.out.println(team1.get(1));
        System.out.println(team1.get(2));
        System.out.println(team1.get(3));
        System.out.println(team1.get(0));
        System.out.println(team2.get(1));
        System.out.println(team2.get(2));
        System.out.println(team2.get(3));
        System.out.println(team2.get(0));
        System.out.println();

    }
}
