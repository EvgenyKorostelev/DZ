public class Pikeman extends MeleeClass{
//    private Integer armorPenetration;

    public Pikeman(String className, Integer level, double health, double healthMax, Integer attack, Integer damageMin, Integer damageMax, Integer defense, Integer speed, Integer stamina) {
        super(className, level, health, healthMax, attack, damageMin, damageMax, defense, speed, stamina);
    }
    @Override
    public String toString() {
        return "Pikeman{" +
                "className='" + className + '\'' +
                ", level=" + level +
                '}';
    }
    @Override
    protected void attackDamage(BaseClass unit) {
        if(stamina >= 1) {
            super.attackDamage(unit);
            unit.defense = armorPenetration(unit);
            stamina -= 1;
        }
    }
    protected Integer armorPenetration(BaseClass unit){
        if((Math.random()*(100 - 1) + 1)<=35) {
            unit.defense = 0;
        }
        return unit.defense;
    }
}
