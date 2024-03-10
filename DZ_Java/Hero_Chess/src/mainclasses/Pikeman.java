package mainclasses;

import mainclasses.subclasses.MeleeClass;
import mainclasses.subclasses.baseclasses.BaseClass;

public class Pikeman extends MeleeClass {
//    private Integer armorPenetration;

    public Pikeman(String name, Integer level, double health, double healthMax, Integer attack,
                   Integer damageMin, Integer damageMax, Integer defense, Integer speed,
                   Integer stamina, Integer staminaMax) {
        super(name, level, health, healthMax, attack, damageMin, damageMax, defense, speed, stamina, staminaMax);
    }
    public Pikeman() {
        this(String.format("Pikeman #%d", ++Pikeman.num), 1, 300, 300,
                30, 30, 40, 30, 3, 2, 2);
    }
    @Override
    public String toString() {
        return "Pikeman{" +
                "name='" + name + '\'' +
                ", level=" + level +
                '}';
    }
    @Override
    public void attackDamage(BaseClass unit) {
        if(stamina >= 1) {
            super.attackDamage(unit);
            unit.defense = armorPenetration(unit);
            stamina -= 1;
        }
    }
    private Integer armorPenetration(BaseClass unit){
        if((Math.random()*(100 - 1) + 1)<=35) {
            unit.defense = 0;
        }
        return unit.defense;
    }
}
