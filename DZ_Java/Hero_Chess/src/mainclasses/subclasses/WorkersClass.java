package mainclasses.subclasses;

import mainclasses.subclasses.baseclasses.BaseClass;

public abstract class WorkersClass extends BaseClass {
    protected Integer fatigue;
    protected Integer fatigueMax;

    protected WorkersClass(String name, Integer level, double health, double healthMax,
                           Integer defense, Integer speed, Integer attack, Integer damageMin,
                           Integer damageMax, Integer fatigue, Integer fatigueMax) {
        super(name, level, health, healthMax, defense, speed, attack, damageMin, damageMax);
        this.fatigueMax = fatigueMax;
        this.fatigue = fatigue;
    }

    @Override
    public void attackDamage(BaseClass unit) {
        super.attackDamage(unit);
    }
}
