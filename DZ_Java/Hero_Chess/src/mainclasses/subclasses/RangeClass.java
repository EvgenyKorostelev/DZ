package mainclasses.subclasses;

import mainclasses.subclasses.baseclasses.BaseClass;
import mainclasses.subclasses.baseclasses.Point;

import java.util.ArrayList;

//Класс обобщающий юнитов дальнего боя
public abstract class RangeClass extends BaseClass {
    protected Integer arrows;
    protected Integer arrowsMax;

    protected RangeClass(String name, Integer level, Point unitpoint, double health, double healthMax,
                         Integer attack, Integer damageMin, Integer damageMax, Integer defense,
                         Integer speed, Integer arrows, Integer arrowsMax, boolean die, String team) {
        super(name, level, unitpoint, health, healthMax, defense, speed, attack, damageMin, damageMax, die, team);
        this.arrowsMax = arrowsMax;
        this.arrows = arrows;
    }

    @Override
    public void attackDamage(BaseClass unit) {
        super.attackDamage(unit);
    }

    @Override
    public void step(ArrayList<BaseClass> enemy, ArrayList<BaseClass> allies) {
        if (!this.die && this.arrows > 0) {
            this.attackDamage(this.findTarget(enemy));
            this.arrows--;
        }
    }

    public Integer getArrows() { return arrows; }

    public Integer getArrowsMax() {
        return arrowsMax;
    }

    public void setArrows(Integer arrows) { this.arrows = arrows; }
}
