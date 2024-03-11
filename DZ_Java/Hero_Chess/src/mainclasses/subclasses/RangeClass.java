package mainclasses.subclasses;

import mainclasses.subclasses.baseclasses.BaseClass;

public abstract class RangeClass extends BaseClass {
    protected Integer arrows;
    protected Integer arrowsMax;

    protected RangeClass(String name, Integer level, double health, double healthMax,
                         Integer attack, Integer damageMin, Integer damageMax, Integer defense,
                         Integer speed, Integer arrows, Integer arrowsMax) {
        super(name, level, health, healthMax, defense, speed, attack, damageMin, damageMax);
        this.arrowsMax = arrowsMax;
        this.arrows = arrows;
    }

    @Override
    public void attackDamage(BaseClass unit) {
        super.attackDamage(unit);
    }
}
