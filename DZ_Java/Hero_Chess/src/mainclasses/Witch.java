package mainclasses;

import mainclasses.subclasses.HealClass;
import mainclasses.subclasses.baseclasses.BaseClass;
import mainclasses.subclasses.baseclasses.Point;

//Класс Колдуны
public class Witch extends HealClass {
    public Witch(String name, Integer level, Point unitpoint, double health, double healthMax, Integer attack,
                 Integer damageMin, Integer damageMax, Integer defense, Integer speed,
                 Integer mana, Integer manaMax, boolean die, String team, String combatLog) {
        super(name, level, unitpoint, health, healthMax, attack, damageMin, damageMax, defense, speed, mana, manaMax, die, team, combatLog);
    }
    public Witch(int x, int y, String team) {
        this(randomName(), 1, new Point(x, y, 10),100, 100,
                1, 35, 45, 10, 1, 150, 150, false, team, "");
    }

    public Witch() {
        this(randomName(), 1, new Point(), 100, 100, 1,
                35, 45, 10, 1, 150, 150, false, "нет", "");
    }

    @Override
    public String toString() {
        return "Ведьма{" + name +
                ", ❤=" + health +
                ", \uD83D\uDD2E=" + mana +
                ", ⚔️=" + attack +
                ", \uD83D\uDEE1️=" + defense +
                ", ⚡=" + speed +
                ", \uD83D\uDEA9" + unitpoint +
                ", \uD83D\uDC80" + die +
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
    //Уникальный метод для колдунов
    private Integer blessOfProtection(BaseClass unit) {
        if ((Math.random() * (100 - 1) + 1) <= 50) {
            unit.setDefense(unit.getDefense() * 2);
        }
        return unit.getDefense();
    }

    @Override
    public String getInfo() {
        return combatLog;
    }
}
