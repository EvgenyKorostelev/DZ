package mainclasses;

import mainclasses.subclasses.HealClass;
import mainclasses.subclasses.baseclasses.BaseClass;
import mainclasses.subclasses.baseclasses.Point;

import java.util.ArrayList;

//Класс Монахи
public class Monk extends HealClass {


    public Monk(String name, Integer level, Point unitpoint, double health, double healthMax, Integer attack,
                Integer damageMin, Integer damageMax, Integer defense, Integer speed,
                Integer mana, Integer manaMax, boolean die, String team) {
        super(name, level, unitpoint, health, healthMax, attack, damageMin, damageMax, defense, speed, mana, manaMax, die, team);
    }
    public Monk(int x, int y, String team) {
        this(randomName(), 1, new Point(x, y, 10),200, 200,
                20, 15, 25, 20, 1, 10, 10, false, team);
    }

    public Monk() {
        this(randomName(), 1,  new Point(), 100, 100,
                1, 30, 80, 10, 1, 150, 150, false, "нет");
    }

    @Override
    public String toString() {
        return "Monk{" +
                "name='" + name + '\'' +
                ", position=" + unitpoint +
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
    //Уникальный метод для монахов
    private Integer blessOfFanaticism(BaseClass unit) {
        if ((Math.random() * (100 - 1) + 1) <= 40) {
            unit.setAttack(unit.getAttack() * 2);
        }
        return unit.getAttack();
    }

    @Override
    public void step(ArrayList<BaseClass> units) {
        if(!this.die){
            this.heal(this.findTarget(units));
        }
    }
}
