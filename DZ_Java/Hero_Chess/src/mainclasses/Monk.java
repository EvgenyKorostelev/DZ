package mainclasses;

import mainclasses.subclasses.HealClass;
import mainclasses.subclasses.baseclasses.BaseClass;

public class Monk extends HealClass {
//   private Integer blessOfFanaticism;

    public Monk(String name, Integer level, double health, double healthMax, Integer attack,
                Integer damageMin, Integer damageMax, Integer defense, Integer speed,
                Integer mana, Integer manaMax) {
        super(name, level, health, healthMax, attack, damageMin, damageMax, defense, speed, mana, manaMax);
    }

    public Monk() {
        this(String.format("Monk #%d", ++Monk.num), 1, 100, 100,
                1, 30, 80, 10, 2, 150, 150);
    }

    @Override
    public String toString() {
        return "Monk{" +
                "name='" + name + '\'' +
                ", level=" + level +
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
