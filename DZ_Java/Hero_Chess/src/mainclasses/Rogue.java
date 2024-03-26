package mainclasses;

import mainclasses.subclasses.MeleeClass;
import mainclasses.subclasses.baseclasses.BaseClass;
import mainclasses.subclasses.baseclasses.Point;

//Класс Разбойники
public class Rogue extends MeleeClass {
    public Rogue(String name, Integer level, Point unitpoint, double health, double healthMax, Integer attack,
                 Integer damageMin, Integer damageMax, Integer defense, Integer speed,
                 Integer stamina, Integer staminaMax, boolean die, String team, String combatLog) {
        super(name, level, unitpoint, health, healthMax, attack, damageMin, damageMax, defense, speed, stamina, staminaMax, die, team, combatLog);
    }
    public Rogue(int x, int y, String team) {
        this(randomName(), 1, new Point(x, y, 10),300, 300,
                30, 25, 75, 30, 2, 10, 10, false, team, "");
    }

    public Rogue() {
        this(randomName(), 1, new Point(), 300, 300, 30,
                25, 75, 30, 2, 2, 2, false, "нет", "");
    }

    @Override
    public String toString() {
        String dieStatus;
        if(die) dieStatus =", \uD83D\uDC80";
        else dieStatus =", ✅";
        return "Разбойник{" + name +
                ", ❤=" + health +
                ", \uD83D\uDCAA=" + stamina +
                ", ⚔️=" + attack +
                ", \uD83D\uDEE1️=" + defense +
                ", ⚡=" + speed +
                ", \uD83D\uDEA9" + unitpoint +
                dieStatus +
                '}';
    }

    @Override
    public void attackDamage(BaseClass unit) {
        //if(если в мили нет противника делает шаг к ближайшему противнику)
        //else(бьет)
        if (stamina > 0) {
            super.attackDamage(unit);
            unit.setAttack(poisoning(unit));
        }
        if(unit.getHealth() <= 0) {
            unit.setDie(true);
            unit.setHealth(0);
        }
    }
    //Уникальный метод для разбойников
    private Integer poisoning(BaseClass unit) {
        if ((Math.random() * (100 - 1) + 1) <= 35) {
            unit.setAttack(1);
        }
        return unit.getAttack();
    }

    @Override
    public String getInfo() {
        return combatLog;
    }
}
