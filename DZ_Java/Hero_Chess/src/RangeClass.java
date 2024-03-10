public class RangeClass extends BaseClass{
    protected Integer arrows;

    public RangeClass(String className, Integer level, double health, double healthMax, Integer attack, Integer damageMin, Integer damageMax, Integer defense, Integer speed, Integer arrows) {
        super(className, level, health, healthMax, defense, speed, attack, damageMin,damageMax);
        this.arrows = arrows;

    }
    @Override
    protected void attackDamage(BaseClass unit) {
        super.attackDamage(unit);
    }
}
