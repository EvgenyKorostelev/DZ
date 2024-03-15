import mainclasses.Peasant;
import mainclasses.Sniper;
import mainclasses.subclasses.baseclasses.BaseClass;

import java.util.ArrayList;



public class Main {
    public static void main(String[] args) {
        //проверка создания команд
        ArrayList<BaseClass> A = BaseClass.createTeam(10, "Alliance");
        ArrayList<BaseClass> H = BaseClass.createTeam(10, "Horde");
        System.out.println(A);
        System.out.println(H);
        System.out.println(BaseClass.createTeam(10, "Horde"));
        System.out.println("=====================================================");
        //проверка findTarget
        System.out.println(A.get(5));
        System.out.println("Ближайший враг: "+A.get(5).findTarget(H));
        System.out.println("=====================================================");
        //проверка step
        Sniper sniper = new Sniper();
        System.out.println(sniper.getArrows());
        System.out.println(sniper.findTarget(H).getHealth());
        sniper.step(H);
        System.out.println(sniper.getArrows());
        System.out.println(sniper.findTarget(H).getHealth());
        System.out.println("=====================================================");
        //проверка turnOrder
        turnOrder(A, H).forEach(i -> System.out.println(i + " " + i.getSpeed()));
        System.out.println("=====================================================");
        // проверка return arrow
        Peasant psn = new Peasant();
        Sniper snp = new Sniper();
        ArrayList<BaseClass> temp = new ArrayList<>();
        ArrayList<BaseClass> temp2 = new ArrayList<>();
        temp.add(snp);
        temp2.add(psn);
        temp.getFirst().step(temp2);
        System.out.println(snp.getArrows());
        psn.returnArrows(temp.getFirst());
        System.out.println(snp.getArrows());
        System.out.println("=====================================================");


    }
    //метод создания списка очередности ходов
    public static ArrayList<BaseClass> turnOrder(ArrayList<BaseClass> team1, ArrayList<BaseClass> team2){
        team1.addAll(team2);
        team1.sort((o1, o2)-> o2.getSpeed() - o1.getSpeed());
        return team1;
    }

}
