package mainclasses;

import mainclasses.subclasses.RangeClass;
import mainclasses.subclasses.baseclasses.BaseClass;
import mainclasses.subclasses.baseclasses.Point;

import java.util.ArrayList;

//Класс Арбалетчики
public class Crossbowman extends RangeClass {


    public Crossbowman(String name, Integer level, Point unitpoint, double health, double healthMax,
                       Integer attack, Integer damageMin, Integer damageMax, Integer defense,
                       Integer speed, Integer arrows, Integer arrowsMax, boolean die, String team) {
        super(name, level, unitpoint, health, healthMax, attack, damageMin, damageMax, defense, speed, arrows, arrowsMax, die, team);
    }

    public Crossbowman(int x, int y, String team) {
        this(randomName(), 1, new Point(x, y, 10), 200, 200,
                20, 25, 75, 20, 3, 10, 10, false, team);
    }

    public Crossbowman() {
        this(randomName(), 1, new Point(), 200, 200,
                20, 15, 25, 20, 3, 10, 10, false, "нет");
    }

    @Override
    public String toString() {
        return "Crossbowman{" +
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

        if (doubleShot()) {
            if(this.unitpoint.distanceTo(unit.getUnitpoint()) >= unitpoint.getFieldsize() / 2) { //зависивость от расстояния до цели
                unit.setHealth(unit.getHealth() - (dmg * hI) / 2);
                dmg = Math.random() * (damageMax - damageMin) + damageMin;//урон для второго выстрела
                unit.setHealth(unit.getHealth() - (dmg * hI) / 2);
            }

            else{
                    unit.setHealth(unit.getHealth() - dmg * hI);
                    dmg = Math.random() * (damageMax - damageMin) + damageMin;//урон для второго выстрела
                    unit.setHealth(unit.getHealth() - dmg * hI);
                }
            }
        else {
            if(this.unitpoint.distanceTo(unit.getUnitpoint()) >= unitpoint.getFieldsize() / 2) //зависивость от расстояния до цели
                {unit.setHealth(unit.getHealth() - (dmg * hI) / 2);}
            else
                {unit.setHealth(unit.getHealth() - dmg * hI);}
        }
        if (unit.getHealth() <= 0) {unit.setDie(true);}
    }

    //Уникальный метод для арбалетчиков
    private boolean doubleShot() {
        return (Math.random() * (100 - 1) + 1) <= 30;
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
