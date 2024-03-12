package mainclasses;

import mainclasses.subclasses.RangeClass;
import mainclasses.subclasses.baseclasses.BaseClass;
import mainclasses.subclasses.baseclasses.Point;

public class Crossbowman extends RangeClass {
//  private Integer doubleShot;

    public Crossbowman(String name, Integer level, Point unitpoint, double health, double healthMax,
                       Integer attack, Integer damageMin, Integer damageMax, Integer defense,
                       Integer speed, Integer arrows, Integer arrowsMax) {
        super(name, level,  unitpoint, health, healthMax, attack, damageMin, damageMax, defense, speed, arrows, arrowsMax);
    }
    public Crossbowman(int x, int y) {
        this(randomName(), 1, new Point(x, y),200, 200,
                20, 15, 25, 20, 4, 10, 10);
    }

    public Crossbowman() {
        this(randomName(), 1, new Point(),200, 200,
                20, 15, 25, 20, 4, 10, 10);
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
        if (arrows >= 1) {
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
//                   if(range >= rangeMax / 2) //зависивость от расстояния до цели
                unit.setHealth(unit.getHealth()- (dmg * hI) / 2);
                dmg = Math.random() * (damageMax - damageMin) + damageMin;//урон для второго выстрела
                unit.setHealth(unit.getHealth() - (dmg * hI) / 2);
//                   else
//                       unit.health = unit.health - dmg * hI;
//                       dmg = Math.random()*(damageMax - damageMin) + damageMin;//урон для второго выстрела
//                       unit.health = unit.health - dmg * hI;
            } else
//                   if(range >= rangeMax / 2) //зависивость от расстояния до цели
//                       unit.health = unit.health - (dmg * hI) / 2;
//                   else
                unit.setHealth(unit.getHealth() - dmg * hI);
            arrows -= 1;
        }
    }

    private boolean doubleShot() {
        return (Math.random() * (100 - 1) + 1) <= 30;
    }
}
