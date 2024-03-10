public class MeleeClass extends BaseClass{
    protected Integer stamina;

    public MeleeClass(String className, Integer level, double health, double healthMax, Integer attack, Integer damageMin, Integer damageMax, Integer defense, Integer speed, Integer stamina) {
        super(className, level, health, healthMax, defense, speed,attack, damageMin, damageMax);
        this.stamina = stamina;
    }
    @Override
    protected void attackDamage(BaseClass unit) {
        super.attackDamage(unit);
    }
}
