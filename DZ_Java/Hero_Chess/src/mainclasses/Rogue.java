package mainclasses;

import mainclasses.subclasses.MeleeClass;
import mainclasses.subclasses.baseclasses.BaseClass;
import mainclasses.subclasses.baseclasses.Point;

import java.util.ArrayList;

//Класс Разбойники
public class Rogue extends MeleeClass {


    public Rogue(String name, Integer level, Point unitpoint, double health, double healthMax, Integer attack,
                 Integer damageMin, Integer damageMax, Integer defense, Integer speed,
                 Integer stamina, Integer staminaMax, boolean die, String team) {
        super(name, level, unitpoint, health, healthMax, attack, damageMin, damageMax, defense, speed, stamina, staminaMax, die, team);
    }
    public Rogue(int x, int y, String team) {
        this(randomName(), 1, new Point(x, y, 10),200, 200,
                20, 15, 25, 20, 2, 10, 10, false, team);
    }

    public Rogue() {
        this(randomName(), 1, new Point(), 300, 300, 30,
                20, 50, 30, 2, 2, 2, false, "нет");
    }

    @Override
    public String toString() {
        return "Rogue{" +
                "name='" + name + '\'' +
                ", position=" + unitpoint +
                '}';
    }

    @Override
    public void attackDamage(BaseClass unit) {
        if (stamina >= 1) {
            super.attackDamage(unit);
            unit.setAttack(poisoning(unit));
            stamina -= 1;
        }
        if(unit.getHealth() <= 0) {unit.setDie(true);}
    }
    //Уникальный метод для разбойников
    private Integer poisoning(BaseClass unit) {
        if ((Math.random() * (100 - 1) + 1) <= 25) {
            unit.setAttack(1);
        }
        return unit.getAttack();
    }

    @Override
    public void step(ArrayList<BaseClass> units) {
        if(!this.die){
            this.attackDamage(this.findTarget(units));
        }
    }
}
