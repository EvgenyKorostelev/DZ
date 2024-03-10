public class HealClass extends BaseClass{
    protected Integer mana;

    public HealClass(String className, Integer level, double health, double healthMax, Integer attack, Integer damageMin, Integer damageMax, Integer defense, Integer speed, Integer mana) {
        super(className, level, health, healthMax, defense, speed, attack, damageMin, damageMax);
        this.mana = mana;
    }

    @Override
    protected void heal(BaseClass unit) {
        super.heal(unit);
    }
}
