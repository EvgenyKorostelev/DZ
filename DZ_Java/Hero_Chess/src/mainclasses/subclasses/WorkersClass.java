package mainclasses.subclasses;

import mainclasses.subclasses.baseclasses.BaseClass;
import mainclasses.subclasses.baseclasses.Point;
//Класс обобщающий персонажей рабочих
public abstract class WorkersClass extends BaseClass {
    protected Integer fatigue;
    protected Integer fatigueMax;

    protected WorkersClass(String name, Integer level, Point unitpoint, double health, double healthMax,
                           Integer defense, Integer speed, Integer attack, Integer damageMin,
                           Integer damageMax, Integer fatigue, Integer fatigueMax, boolean die, String team, String combatLog) {
        super(name, level, unitpoint, health, healthMax, defense, speed, attack, damageMin, damageMax, die, team, combatLog);
        this.fatigueMax = fatigueMax;
        this.fatigue = fatigue;
    }

    @Override
    public void attackDamage(BaseClass unit) {
        super.attackDamage(unit);
    }

    public Integer getFatigue() { return fatigue; }

    public void setFatigue(Integer fatigue) { this.fatigue = fatigue; }
}
