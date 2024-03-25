package mainclasses;

import mainclasses.subclasses.RangeClass;
import mainclasses.subclasses.baseclasses.BaseClass;
import mainclasses.subclasses.baseclasses.Point;

//Класс Арбалетчики
public class Crossbowman extends RangeClass {
    public Crossbowman(String name, Integer level, Point unitpoint, double health, double healthMax,
                       Integer attack, Integer damageMin, Integer damageMax, Integer defense,
                       Integer speed, Integer arrows, Integer arrowsMax, boolean die, String team, String combatLog) {
        super(name, level, unitpoint, health, healthMax, attack, damageMin, damageMax, defense, speed, arrows, arrowsMax, die, team, combatLog);
    }

    public Crossbowman(int x, int y, String team) {
        this(randomName(), 1, new Point(x, y, 10), 200, 200,
                20, 35, 55, 20, 3, 10, 10, false, team, "");
    }

    public Crossbowman() {
        this(randomName(), 1, new Point(), 200, 200,
                20, 35, 55, 20, 3, 10, 10, false, "нет", "");
    }

    @Override
    public String toString() {
        return "Арбалетчик{" + name +
                ", ❤=" + health +
                ", \uD83C\uDFF9=" + arrows +
                ", ⚔️=" + attack +
                ", \uD83D\uDEE1️=" + defense +
                ", ⚡=" + speed +
                ", \uD83D\uDEA9" + unitpoint +
                ", \uD83D\uDC80" + die +
                '}';
    }

    @Override
    public void attackDamage(BaseClass unit) {
        int i;
        int signI;
        int absI;
        double hI;
        double dmg = Math.random() * (damageMax - damageMin) + damageMin;
        i = attack - unit.getDefense();
        signI = Integer.compare(i, 0);
        if (i < 0) {
            absI = -i;
        } else {
            absI = i;
        }
        hI = (1 + 0.1 * Math.pow(0.1 * signI, absI));

        if (doubleShot()) {
            if(this.unitpoint.distanceTo(unit.getUnitpoint()) >= (double) unitpoint.getFieldsize() / 2) { //зависимость от расстояния до цели
                unit.setHealth(unit.getHealth() - dmg * hI / 2);
                dmg = Math.random() * (damageMax - damageMin) + damageMin;//урон для второго выстрела
                unit.setHealth(unit.getHealth() - dmg * hI / 2);
            }
            else{
                    unit.setHealth(unit.getHealth() - dmg * hI);
                    dmg = Math.random() * (damageMax - damageMin) + damageMin;//урон для второго выстрела
                    unit.setHealth(unit.getHealth() - dmg * hI);
                }
            }
        else {
            if(this.unitpoint.distanceTo(unit.getUnitpoint()) >= (double) unitpoint.getFieldsize() / 2) //зависимость от расстояния до цели
                {unit.setHealth(unit.getHealth() - dmg * hI / 2);}
            else
                {unit.setHealth(unit.getHealth() - dmg * hI);}
        }
        if (unit.getHealth() <= 0) {
            unit.setDie(true);
            unit.setHealth(0);
        }
    }

    //Уникальный метод для арбалетчиков
    private boolean doubleShot() {
        return (Math.random() * (100 - 1) + 1) <= 30;
    }

    @Override
    public Integer getArrows() {
        return super.getArrows();
    }

    @Override
    public String getInfo() {
        return combatLog;
    }

}
