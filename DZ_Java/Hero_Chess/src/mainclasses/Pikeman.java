package mainclasses;

import mainclasses.subclasses.MeleeClass;
import mainclasses.subclasses.baseclasses.BaseClass;
import mainclasses.subclasses.baseclasses.Point;

import java.util.ArrayList;

//Класс Копейщики
public class Pikeman extends MeleeClass {


    public Pikeman(String name, Integer level, Point unitpoint, double health, double healthMax, Integer attack,
                   Integer damageMin, Integer damageMax, Integer defense, Integer speed,
                   Integer stamina, Integer staminaMax, boolean die) {
        super(name, level, unitpoint, health, healthMax, attack, damageMin, damageMax, defense, speed, stamina, staminaMax, die);
    }
    public Pikeman(int x, int y) {
        this(randomName(), 1, new Point(x, y, 10),200, 200,
                20, 15, 25, 20, 2, 10, 10, false);
    }

    public Pikeman() {
        this(randomName(), 1, new Point(), 300, 300,
                30, 30, 40, 30, 2, 2, 2, false);
    }

    @Override
    public String toString() {
        return "Pikeman{" +
                "name='" + name + '\'' +
                ", position=" + unitpoint +
                '}';
    }

    @Override
    public void attackDamage(BaseClass unit) {
        if (stamina >= 1) {
            super.attackDamage(unit);
            unit.setDefense(armorPenetration(unit));
            stamina -= 1;
        }
        if(unit.getHealth() <= 0) {unit.setDie(true);}
    }
    //Уникальный метод для копейщиков
    private Integer armorPenetration(BaseClass unit) {
        if ((Math.random() * (100 - 1) + 1) <= 35) {
            unit.setDefense(0);
        }
        return unit.getDefense();
    }

    @Override
    public void step(ArrayList<BaseClass> units) {
        if(!this.die){
            this.attackDamage(this.findTarget(units));
        }
    }
}
