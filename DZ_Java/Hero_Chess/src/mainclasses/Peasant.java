package mainclasses;

import mainclasses.subclasses.RangeClass;
import mainclasses.subclasses.WorkersClass;
import mainclasses.subclasses.baseclasses.BaseClass;
import mainclasses.subclasses.baseclasses.Point;

import java.util.ArrayList;

//Класс Крестьяне
public class Peasant extends WorkersClass {
    public Peasant(String name, Integer level, Point unitpoint, double health, double healthMax, Integer defense, Integer speed,
                   Integer attack, Integer damageMin, Integer damageMax, Integer fatigue, Integer fatigueMax, boolean die, String team, String combatLog) {
        super(name, level, unitpoint, health, healthMax, defense, speed, attack, damageMin, damageMax, fatigue, fatigueMax, die, team, combatLog);
    }
    public Peasant(int x, int y, String team) {
        this(randomName(), 1, new Point(x, y, 10),50, 50,
                1, 0, 1, 1, 1, 3, 3, false, team, "");
    }

    public Peasant() {
        this(randomName(), 1, new Point(), 50, 50, 1,
                0, 1, 1, 1, 3, 3, false, "нет", "");
    }

    @Override
    public String toString() {
        String dieStatus;
        if(die) dieStatus =", \uD83D\uDC80";
        else dieStatus =", ✅";
        return "Крестьянин{" + name +
                ", ❤=" + health +
                ", ♻=" + fatigue +
                ", ⚔️=" + attack +
                ", \uD83D\uDEE1️=" + defense +
                ", ⚡=" + speed +
                ", \uD83D\uDEA9" + unitpoint +
                dieStatus +
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
    public void step(ArrayList<BaseClass> enemy, ArrayList<BaseClass> allies) {
        combatLog="";
        if(!this.die){
            int min = Integer.MAX_VALUE;
            RangeClass allieShooter = null;
            for(BaseClass unit : allies){
                if(RangeClass.class.isAssignableFrom(unit.getClass())){
                   if (((RangeClass) unit).getArrows() < min && ((RangeClass) unit).getArrows() < ((RangeClass) unit).getArrowsMax()){
                       min = ((RangeClass) unit).getArrows();
                       allieShooter = ((RangeClass) unit);
                   }
                }
            }
            if (allieShooter != null) {
                returnArrows(allieShooter);
                this.combatLog = this.toString().charAt(0) + " " + this.name + " return arrow to: " + allieShooter.toString().charAt(0) + " " + allieShooter.getName();
            }
            //else this.attackDamage(this.findTarget(units));
            else {
                this.combatLog = this.toString().charAt(0) + " " + this.name + " awaits his fate !";
            }
        }
    }

    @Override
    public String getInfo() {
        return combatLog;
    }
}
