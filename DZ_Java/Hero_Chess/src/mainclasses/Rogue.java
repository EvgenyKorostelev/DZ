package mainclasses;

import mainclasses.subclasses.MeleeClass;
import mainclasses.subclasses.baseclasses.BaseClass;
import mainclasses.subclasses.baseclasses.Point;

public class Rogue extends MeleeClass {
//    private boolean poisoning;

    public Rogue(String name, Integer level, Point unitpoint, double health, double healthMax, Integer attack,
                 Integer damageMin, Integer damageMax, Integer defense, Integer speed,
                 Integer stamina, Integer staminaMax) {
        super(name, level, unitpoint, health, healthMax, attack, damageMin, damageMax, defense, speed, stamina, staminaMax);
    }
    public Rogue(int x, int y) {
        this(randomName(), 1, new Point(x, y, 10),200, 200,
                20, 15, 25, 20, 4, 10, 10);
    }

    public Rogue() {
        this(randomName(), 1, new Point(), 300, 300, 30,
                20, 50, 30, 3, 2, 2);
    }

    @Override
    public String toString() {
        return "Rogue{" +
                "name='" + name + '\'' +
                ", position=" + unitpoint +
                '}';
    }

    @Override
    public void attackDamage(BaseClass unit) {
        if (stamina >= 1) {
            super.attackDamage(unit);
            unit.setAttack(poisoning(unit));
            stamina -= 1;
        }
    }

    private Integer poisoning(BaseClass unit) {
        if ((Math.random() * (100 - 1) + 1) <= 25) {
            unit.setAttack(1);
        }
        return unit.getAttack();
    }
}
