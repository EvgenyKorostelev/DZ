import mainclasses.subclasses.baseclasses.BaseClass;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        ArrayList<BaseClass> A = BaseClass.createTeam(10, "Alliance");
        ArrayList<BaseClass> H = BaseClass.createTeam(10, "Horde");
        System.out.println(BaseClass.createTeam(10, "Alliance"));
        System.out.println();
        System.out.println(BaseClass.createTeam(10, "Horde"));
        System.out.println();

        System.out.println("Ближайший враг: "+A.get(3).findTarget(H));
    }
}
