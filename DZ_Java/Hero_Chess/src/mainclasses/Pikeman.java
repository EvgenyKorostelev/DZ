package mainclasses;

import mainclasses.subclasses.MeleeClass;
import mainclasses.subclasses.baseclasses.BaseClass;
import mainclasses.subclasses.baseclasses.Point;

//Класс Копейщики
public class Pikeman extends MeleeClass {
    public Pikeman(String name, Integer level, Point unitpoint, double health, double healthMax, Integer attack,
                   Integer damageMin, Integer damageMax, Integer defense, Integer speed,
                   Integer stamina, Integer staminaMax, boolean die, String team) {
        super(name, level, unitpoint, health, healthMax, attack, damageMin, damageMax, defense, speed, stamina, staminaMax, die, team);
    }
    public Pikeman(int x, int y, String team) {
        this(randomName(), 1, new Point(x, y, 10),300, 300,
                30, 25, 75, 30, 2, 10, 10, false, team);
    }

    public Pikeman() {
        this(randomName(), 1, new Point(), 300, 300,
                30, 25, 75, 30, 2, 2, 2, false, "нет");
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
        //if(если в мили нет противника делает шаг к ближайшему противнику)
        //else(бьет)
        if (stamina >= 1) {
            super.attackDamage(unit);
            unit.setDefense(armorPenetration(unit));

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
}
