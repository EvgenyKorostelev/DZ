package mainclasses.subclasses;

import mainclasses.subclasses.baseclasses.BaseClass;
import mainclasses.subclasses.baseclasses.Point;

import java.util.ArrayList;

//Класс обобщающий персонажей лекарей
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
    //Метод возрождения союзника
    public boolean resurrection(BaseClass unit){
        if(this.mana >= 50){
            unit.setHealth(unit.getHealthMax()/2);
            this.setMana(this.getMana() - 50);
            return true;
        }
        else return false;
    }
    @Override
    public void step(ArrayList<BaseClass> enemy, ArrayList<BaseClass> allies) {
        combatLog = "";
        if (!this.die && enemy.stream().filter(BaseClass::getDie).count() < 10) {
            if (allies.stream().filter(BaseClass::getDie).count() > 3) {
                BaseClass allieToRes = allies.stream()
                        .filter(BaseClass::getDie)
                        .sorted((n1, n2) -> n2.getSpeed() - n1.getSpeed())
                        .toList().getFirst();
                if (!this.resurrection(allieToRes)) {
                    this.mana += 5;
                    this.combatLog = this.toString().charAt(0) + " " + this.name + " awaits his fate !";
                } else {
                    allieToRes.setDie(false);
                    this.combatLog = this.toString().charAt(0) + " " + this.name + " resurrection: " +
                            allieToRes.toString().charAt(0) + " " + allieToRes.getName() + " health: " + (allieToRes.getHealth());
                }
            } else {
                if (this.mana >= 10) {
                    BaseClass allieToHeal = allies.getFirst();
                    for (BaseClass unit : allies) {
                        if (!unit.getDie() && unit.getHealth() < unit.getHealthMax()) {
                            if (allieToHeal.getHealth() / allieToHeal.getHealthMax() * 100 > unit.getHealth() / unit.getHealthMax() * 100)
                                allieToHeal = unit;
                        }
                    }
                    if (allieToHeal.getHealth() < allieToHeal.getHealthMax()) {
                        double hpBefore = allieToHeal.getHealth();
                        this.heal(allieToHeal);
                        double hpAfter = allieToHeal.getHealth();
                        this.combatLog = this.toString().charAt(0) + " " + this.name + " healed: " +
                                allieToHeal.toString().charAt(0) + " " + allieToHeal.getName() + " health: " + (hpAfter - hpBefore);
                    } else if (allieToHeal.getHealth() == allieToHeal.getHealthMax()) {
                        this.combatLog = this.toString().charAt(0) + " " + this.name + " no wounded !";
                    }
                } else if (this.mana == 0) {
                    this.mana += 5;
                    this.combatLog = this.toString().charAt(0) + " " + this.name + " awaits his fate !";
                }
            }
        }
    }
    public Integer getMana() { return mana; }
    public void setMana(Integer mana) { this.mana = mana; }
}
