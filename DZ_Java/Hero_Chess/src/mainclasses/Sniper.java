package mainclasses;

import mainclasses.subclasses.RangeClass;
import mainclasses.subclasses.baseclasses.BaseClass;
import mainclasses.subclasses.baseclasses.Point;

import java.util.ArrayList;

//Класс Снайперы
public class Sniper extends RangeClass {


    public Sniper(String name, Integer level, Point unitpoint, double health, double healthMax, Integer attack,
                  Integer damageMin, Integer damageMax, Integer defense, Integer speed,
                  Integer arrows, Integer arrowsMax, boolean die, String team) {
        super(name, level, unitpoint, health, healthMax, attack, damageMin, damageMax, defense, speed, arrows, arrowsMax, die, team);
    }

    public Sniper(int x, int y, String team) {
        this(randomName(), 1, new Point(x, y, 10), 200, 200,
                20, 15, 75, 20, 3, 10, 10, false, team);
    }

    public Sniper() {
        this(randomName(), 1, new Point(), 200, 200, 20,
                10, 30, 20, 3, 10, 10, false, "нет");
    }

    @Override
    public String toString() {
        return "Sniper{" +
                "name='" + name + '\'' +
                ", position=" + unitpoint +
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

        if (i < 0) {
            signI = -1;
        } else if (i == 0) {
            signI = 0;
        } else {
            signI = 1;
        }

        if (i < 0) {
            absI = -i;
        } else {
            absI = i;
        }

        hI = (1 + 0.1 * Math.pow(0.1 * signI, absI));

        if (snipeShot()) {
            unit.setHealth(unit.getHealth() - (dmg * hI) * 1.5);
        } else {
            unit.setHealth(unit.getHealth() - dmg * hI);
        }
        if (unit.getHealth() <= 0) {
            unit.setDie(true);
        }

    }

    //Уникальный метод для снайперов
    private boolean snipeShot() {
        return (Math.random() * (100 - 1) + 1) <= 60;
    }

    @Override
    public void step(ArrayList<BaseClass> units) {
        if (!this.die && this.arrows > 0) {
            this.attackDamage(this.findTarget(units));
            this.arrows--;
        }

    }

    @Override
    public Integer getArrows() {
        return super.getArrows();
    }
}
