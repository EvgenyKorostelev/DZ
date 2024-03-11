import mainclasses.*;
import mainclasses.subclasses.baseclasses.BaseClass;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<BaseClass> black = new ArrayList<>();
        List<BaseClass> white = new ArrayList<>();


        System.out.println(BaseClass.createTeam(10, "A"));
        System.out.println();
        System.out.println(BaseClass.createTeam(10, "H"));


    }
}
