package mainclasses;

import mainclasses.subclasses.HealClass;
import mainclasses.subclasses.baseclasses.BaseClass;
import mainclasses.subclasses.baseclasses.Point;

public class Witch extends HealClass {
//   private Integer blessOfProtection;

    public Witch(String name, Integer level, Point unitpoint, double health, double healthMax, Integer attack,
                 Integer damageMin, Integer damageMax, Integer defense, Integer speed,
                 Integer mana, Integer manaMax) {
        super(name, level, unitpoint, health, healthMax, attack, damageMin, damageMax, defense, speed, mana, manaMax);
    }
    public Witch(int x, int y) {
        this(randomName(), 1, new Point(x, y, 10),200, 200,
                20, 15, 25, 20, 4, 10, 10);
    }

    public Witch() {
        this(randomName(), 1, new Point(), 100, 100, 1,
                4, 65, 10, 2, 150, 150);
    }

    @Override
    public String toString() {
        return "Witch{" +
                "name='" + name + '\'' +
                ", position=" + unitpoint +
                '}';
    }

    @Override
    public void heal(BaseClass unit) {
        if (mana >= 10) {
            super.heal(unit);
            unit.setDefense(blessOfProtection(unit));
            mana -= 10;
        }
    }

    private Integer blessOfProtection(BaseClass unit) {
        if ((Math.random() * (100 - 1) + 1) <= 50) {
            unit.setDefense(unit.getDefense() * 2);
        }
        return unit.getDefense();
    }
}
