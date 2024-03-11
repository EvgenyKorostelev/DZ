package mainclasses;

import mainclasses.subclasses.MeleeClass;
import mainclasses.subclasses.baseclasses.BaseClass;

public class Rogue extends MeleeClass {
//    private boolean poisoning;

    public Rogue(String name, Integer level, double health, double healthMax, Integer attack,
                 Integer damageMin, Integer damageMax, Integer defense, Integer speed,
                 Integer stamina, Integer staminaMax) {
        super(name, level, health, healthMax, attack, damageMin, damageMax, defense, speed, stamina, staminaMax);
    }

    public Rogue() {
        this(String.format("Rogue #%d", ++Rogue.num), 1, 300, 300, 30,
                20, 50, 30, 3, 2, 2);
    }

    @Override
    public String toString() {
        return "Rogue{" +
                "name='" + name + '\'' +
                ", level=" + level +
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
