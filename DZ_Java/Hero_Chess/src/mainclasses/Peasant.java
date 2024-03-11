package mainclasses;

import mainclasses.subclasses.WorkersClass;
import mainclasses.subclasses.baseclasses.BaseClass;

public class Peasant extends WorkersClass {
//    private Integer returnArrows;

    public Peasant(String name, Integer level, double health, double healthMax, Integer defense, Integer speed,
                   Integer attack, Integer damageMin, Integer damageMax, Integer fatigue, Integer fatigueMax) {
        super(name, level, health, healthMax, defense, speed, attack, damageMin, damageMax, fatigue, fatigueMax);
    }

    public Peasant() {
        this(String.format("Peasant #%d", ++Peasant.num), 1, 50, 50, 1,
                1, 1, 1, 1, 3, 3);
    }

    @Override
    public String toString() {
        return "Peasant{" +
                "name='" + name + '\'' +
                ", level=" + level +
                '}';
    }

    @Override
    public void attackDamage(BaseClass unit) {
        super.attackDamage(unit);
    }
}
