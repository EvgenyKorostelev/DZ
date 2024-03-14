package mainclasses.subclasses;

import mainclasses.subclasses.baseclasses.BaseClass;
import mainclasses.subclasses.baseclasses.Point;
//Класс обобщающий юнитов ближнего боя
public abstract class MeleeClass extends BaseClass {
    protected Integer stamina;
    protected Integer staminaMax;

    protected MeleeClass(String name, Integer level, Point unitpoint, double health, double healthMax,
                         Integer attack, Integer damageMin, Integer damageMax, Integer defense,
                         Integer speed, Integer stamina, Integer staminaMax, boolean die) {
        super(name, level, unitpoint, health, healthMax, defense, speed, attack, damageMin, damageMax, die);
        this.staminaMax = staminaMax;
        this.stamina = stamina;
    }

    @Override
    public void attackDamage(BaseClass unit) {
        super.attackDamage(unit);
    }

    public Integer getStamina() { return stamina; }

    public void setStamina(Integer stamina) { this.stamina = stamina; }
}
