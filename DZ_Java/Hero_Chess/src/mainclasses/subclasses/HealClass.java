package mainclasses.subclasses;

import mainclasses.subclasses.baseclasses.BaseClass;

public abstract class HealClass extends BaseClass {
    protected Integer mana;
    protected Integer manaMax;

    protected HealClass(String name, Integer level, double health, double healthMax,
                        Integer attack, Integer damageMin, Integer damageMax, Integer defense,
                        Integer speed, Integer mana, Integer manaMax) {
        super(name, level, health, healthMax, defense, speed, attack, damageMin, damageMax);
        this.manaMax = manaMax;
        this.mana = mana;
    }

    @Override
    public void heal(BaseClass unit) {
        super.heal(unit);
    }

    public Integer getMana() { return mana; }

    public void setMana(Integer mana) { this.mana = mana; }
}
