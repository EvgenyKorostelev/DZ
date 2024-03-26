package mainclasses;

import mainclasses.subclasses.HealClass;
import mainclasses.subclasses.baseclasses.BaseClass;
import mainclasses.subclasses.baseclasses.Point;

//Класс Монахи
public class Monk extends HealClass {
    public Monk(String name, Integer level, Point unitpoint, double health, double healthMax, Integer attack,
                Integer damageMin, Integer damageMax, Integer defense, Integer speed,
                Integer mana, Integer manaMax, boolean die, String team, String combatLog) {
        super(name, level, unitpoint, health, healthMax, attack, damageMin, damageMax, defense, speed, mana, manaMax, die, team, combatLog);
    }
    public Monk(int x, int y, String team) {
        this(randomName(), 1, new Point(x, y, 10),100, 100,
                1, 25, 35, 10, 1, 150, 150, false, team, "");
    }

    public Monk() {
        this(randomName(), 1,  new Point(), 100, 100,
                1, 25, 35, 10, 1, 150, 150, false, "нет", "");
    }

    @Override
    public String toString() {
        String dieStatus;
        if(die) dieStatus =", \uD83D\uDC80";
        else dieStatus =", ✅";
        return "Монах{" + name +
                ", ❤=" + health +
                ", \uD83D\uDD2E=" + mana +
                ", ⚔️=" + attack +
                ", \uD83D\uDEE1️=" + defense +
                ", ⚡=" + speed +
                ", \uD83D\uDEA9" + unitpoint +
                dieStatus +
                '}';
    }

    @Override
    public void heal(BaseClass unit) {
        if (mana >= 10) {
            super.heal(unit);
            unit.setAttack(blessOfFanaticism(unit));
            mana -= 10;
        }
    }
    //Уникальный метод для монахов
    private Integer blessOfFanaticism(BaseClass unit) {
        if ((Math.random() * (100 - 1) + 1) <= 40) {
            unit.setAttack(unit.getAttack() * 4);
        }
        return unit.getAttack();
    }

    @Override
    public String getInfo() {
        return combatLog;
    }
}
