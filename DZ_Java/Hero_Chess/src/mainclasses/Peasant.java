package mainclasses;

import mainclasses.subclasses.RangeClass;
import mainclasses.subclasses.WorkersClass;
import mainclasses.subclasses.baseclasses.BaseClass;
import mainclasses.subclasses.baseclasses.Point;

import java.util.ArrayList;

//Класс Крестьяне
public class Peasant extends WorkersClass {
//    private Integer returnArrows;

    public Peasant(String name, Integer level, Point unitpoint, double health, double healthMax, Integer defense, Integer speed,
                   Integer attack, Integer damageMin, Integer damageMax, Integer fatigue, Integer fatigueMax, boolean die, String team) {
        super(name, level, unitpoint, health, healthMax, defense, speed, attack, damageMin, damageMax, fatigue, fatigueMax, die, team);
    }
    public Peasant(int x, int y, String team) {
        this(randomName(), 1, new Point(x, y, 10),200, 200,
                20, 0, 25, 20, 4, 10, 10, false, team);
    }

    public Peasant() {
        this(randomName(), 1, new Point(), 50, 50, 1,
                0, 1, 1, 1, 3, 3, false, "нет");
    }

    @Override
    public String toString() {
        return "Peasant{" +
                "name='" + name + '\'' +
                    ", position=" + unitpoint +
                '}';
    }

    @Override
    public void attackDamage(BaseClass unit) {
        super.attackDamage(unit);
    }

    public void returnArrows(BaseClass unit){
        if(RangeClass.class.isAssignableFrom(unit.getClass())) {
            if (((RangeClass) unit).getArrows() < ((RangeClass) unit).getArrowsMax())
                ((RangeClass) unit).setArrows(((RangeClass) unit).getArrows() + 1);
        }
    }

    @Override
    public void step(ArrayList<BaseClass> units) {
        if(!this.die){
            int min = 10;
            RangeClass temp = null;
            for(BaseClass unit : units){
                if(RangeClass.class.isAssignableFrom(unit.getClass())){
                   if (((RangeClass) unit).getArrows() < min){
                       min = ((RangeClass) unit).getArrows();
                       temp = ((RangeClass) unit);
                   }
                }
            }
            if (temp != null)
                returnArrows(temp);
        }
    }
}
