public class Workers extends BaseClass {
    protected Integer fatigue;
    public Workers(String className, Integer level, double health, double healthMax, Integer defense, Integer speed, Integer attack, Integer damageMin, Integer damageMax, Integer fatigue) {
        super(className, level, health, healthMax, defense, speed, attack, damageMin, damageMax);
        this.fatigue = fatigue;
    }

    @Override
    protected void attackDamage(BaseClass unit) {super.attackDamage(unit);
    }
}
