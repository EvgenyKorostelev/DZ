package mainclasses.subclasses;

import mainclasses.subclasses.baseclasses.BaseClass;
import mainclasses.subclasses.baseclasses.Point;
//Класс обобщающий юнитов дальнего боя
public abstract class RangeClass extends BaseClass {
    protected Integer arrows;
    protected Integer arrowsMax;

    protected RangeClass(String name, Integer level, Point unitpoint, double health, double healthMax,
                         Integer attack, Integer damageMin, Integer damageMax, Integer defense,
                         Integer speed, Integer arrows, Integer arrowsMax, boolean die) {
        super(name, level, unitpoint, health, healthMax, defense, speed, attack, damageMin, damageMax, die);
        this.arrowsMax = arrowsMax;
        this.arrows = arrows;
    }

    @Override
    public void attackDamage(BaseClass unit) {
        super.attackDamage(unit);
    }

    public Integer getArrows() { return arrows; }

    public Integer getArrowsMax() {
        return arrowsMax;
    }

    public void setArrows(Integer arrows) { this.arrows = arrows; }
}
