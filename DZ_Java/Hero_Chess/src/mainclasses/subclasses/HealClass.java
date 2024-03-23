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
                        Integer speed, Integer mana, Integer manaMax, boolean die, String team, String combatLog) {
        super(name, level, unitpoint, health, healthMax, defense, speed, attack, damageMin, damageMax, die, team, combatLog);
        this.manaMax = manaMax;
        this.mana = mana;
    }

    @Override
    public void heal(BaseClass unit) {
        super.heal(unit);
    }
    @Override
    public void step(ArrayList<BaseClass> enemy, ArrayList<BaseClass> allies) {
        combatLog="";
        if(!this.die && this.mana > 0){
            BaseClass allie = allies.getFirst();
            for(BaseClass unit : allies){
                if(!unit.getDie() && unit.getHealth() < unit.getHealthMax()){
                    if(allie.getHealth() / allie.getHealthMax() * 100 > unit.getHealth() / unit.getHealthMax() * 100)
                        allie = unit;
                }
            }
            double hpBefore = allie.getHealth();
            this.heal(allie);
            double hpAfter = allie.getHealth();
            this.combatLog = this.toString().charAt(0) + " " + this.name + " healed: " + allie.toString().charAt(0) + " " + allie.getName() + " health: " + (hpAfter - hpBefore);
        } else if (!this.die && this.mana == 0) {
            this.combatLog = this.toString().charAt(0) + " " + this.name + " awaits his fate !";
        }
        System.out.println(getInfo());
    }

    public Integer getMana() { return mana; }

    public void setMana(Integer mana) { this.mana = mana; }
}
