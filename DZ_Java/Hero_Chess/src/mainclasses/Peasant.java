package mainclasses;

import mainclasses.subclasses.WorkersClass;
import mainclasses.subclasses.baseclasses.BaseClass;
import mainclasses.subclasses.baseclasses.Point;

public class Peasant extends WorkersClass {
//    private Integer returnArrows;

    public Peasant(String name, Integer level, Point unitpoint, double health, double healthMax, Integer defense, Integer speed,
                   Integer attack, Integer damageMin, Integer damageMax, Integer fatigue, Integer fatigueMax) {
        super(name, level, unitpoint, health, healthMax, defense, speed, attack, damageMin, damageMax, fatigue, fatigueMax);
    }
    public Peasant(int x, int y) {
        this(randomName(), 1, new Point(x, y, 10),200, 200,
                20, 15, 25, 20, 4, 10, 10);
    }

    public Peasant() {
        this(randomName(), 1, new Point(), 50, 50, 1,
                1, 1, 1, 1, 3, 3);
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
}
