import mainclasses.Sniper;
import mainclasses.subclasses.baseclasses.BaseClass;

import java.util.ArrayList;



public class Main {
    public static void main(String[] args) {
        ArrayList<BaseClass> A = BaseClass.createTeam(10, "Alliance");
        ArrayList<BaseClass> H = BaseClass.createTeam(10, "Horde");
        System.out.println(A);
        System.out.println(H);
        System.out.println(BaseClass.createTeam(10, "Horde"));
        System.out.println();
        System.out.println(A.get(5));
        System.out.println("Ближайший враг: "+A.get(5).findTarget(H));

        Sniper sniper = new Sniper();
        System.out.println(sniper.getArrows());
        System.out.println(sniper.findTarget(H).getHealth());
        sniper.step(H);
        System.out.println(sniper.getArrows());
        System.out.println(sniper.findTarget(H).getHealth());

        turnOrder(A, H).forEach(i -> System.out.println(i + " " + i.getSpeed()));
    }

    public static ArrayList<BaseClass> turnOrder(ArrayList<BaseClass> team1, ArrayList<BaseClass> team2){
        ArrayList<BaseClass> temp = team1;
        temp.addAll(team2);
        temp.sort((o1, o2)-> o2.getSpeed() - o1.getSpeed());
        return temp;
    }
    
}
