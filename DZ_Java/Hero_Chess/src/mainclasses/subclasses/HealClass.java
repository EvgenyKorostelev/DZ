package mainclasses.subclasses;

import mainclasses.subclasses.baseclasses.BaseClass;
import mainclasses.subclasses.baseclasses.Point;

import java.util.ArrayList;

//Класс обобщающий юнитов лекарей
public abstract class HealClass extends BaseClass {
    protected Integer mana;
    protected Integer manaMax;

    protected HealClass(String name, Integer level, Point unitpoint, double health, double healthMax,
                        Integer attack, Integer damageMin, Integer damageMax, Integer defense,
                        Integer speed, Integer mana, Integer manaMax, boolean die, String team) {
        super(name, level, unitpoint, health, healthMax, defense, speed, attack, damageMin, damageMax, die, team);
        this.manaMax = manaMax;
        this.mana = mana;
    }

    @Override
    public void heal(BaseClass unit) {
        super.heal(unit);
    }
    @Override
    public void step(ArrayList<BaseClass> enemy, ArrayList<BaseClass> allies) {
        if(!this.die){
            this.heal(this.findTarget(allies));
        }
    }

    public Integer getMana() { return mana; }

    public void setMana(Integer mana) { this.mana = mana; }
}
