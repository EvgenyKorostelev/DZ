package mainclasses;

import mainclasses.subclasses.HealClass;
import mainclasses.subclasses.baseclasses.BaseClass;
import mainclasses.subclasses.baseclasses.Point;

public class Monk extends HealClass {
//   private Integer blessOfFanaticism;

    public Monk(String name, Integer level, Point unitpoint, double health, double healthMax, Integer attack,
                Integer damageMin, Integer damageMax, Integer defense, Integer speed,
                Integer mana, Integer manaMax) {
        super(name, level, unitpoint, health, healthMax, attack, damageMin, damageMax, defense, speed, mana, manaMax);
    }
    public Monk(int x, int y) {
        this(randomName(), 1, new Point(x, y, 10),200, 200,
                20, 15, 25, 20, 4, 10, 10);
    }

    public Monk() {
        this(randomName(), 1,  new Point(), 100, 100,
                1, 30, 80, 10, 2, 150, 150);
    }

    @Override
    public String toString() {
        return "Monk{" +
                "name='" + name + '\'' +
                ", position=" + unitpoint +
                '}';
    }

    @Override
    public void heal(BaseClass unit) {
        if (mana >= 15) {
            super.heal(unit);
            unit.setAttack(blessOfFanaticism(unit));
            mana -= 15;
        }
    }

    private Integer blessOfFanaticism(BaseClass unit) {
        if ((Math.random() * (100 - 1) + 1) <= 40) {
            unit.setAttack(unit.getAttack() * 2);
        }
        return unit.getAttack();
    }
}
