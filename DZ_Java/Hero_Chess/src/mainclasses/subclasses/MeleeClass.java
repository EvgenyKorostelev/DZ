package mainclasses.subclasses;

import mainclasses.subclasses.baseclasses.BaseClass;

public abstract class MeleeClass extends BaseClass {
    protected Integer stamina;
    protected Integer staminaMax;

    protected MeleeClass(String name, Integer level, double health, double healthMax,
                         Integer attack, Integer damageMin, Integer damageMax, Integer defense,
                         Integer speed, Integer stamina, Integer staminaMax) {
        super(name, level, health, healthMax, defense, speed, attack, damageMin, damageMax);
        this.staminaMax = staminaMax;
        this.stamina = stamina;
    }

    @Override
    public void attackDamage(BaseClass unit) {
        super.attackDamage(unit);
    }
}
