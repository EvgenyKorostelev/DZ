public class Rogue extends MeleeClass{
//    private boolean poisoning;

    public Rogue(String className, Integer level, double health, double healthMax, Integer attack, Integer damageMin, Integer damageMax, Integer defense, Integer speed, Integer stamina) {
        super(className, level, health, healthMax, attack, damageMin, damageMax, defense, speed, stamina);
    }
    @Override
    public String toString() {
        return "Rogue{" +
                "className='" + className + '\'' +
                ", level=" + level +
                '}';
    }
    @Override
    protected void attackDamage(BaseClass unit) {
        if(stamina >= 1) {
            super.attackDamage(unit);
            unit.attack = poisoning(unit);
            stamina -= 1;
        }
    }

    protected Integer poisoning(BaseClass unit){
        if((Math.random()*(100 - 1) + 1)<=25) {
            unit.attack = 1;
        }
        return unit.attack;
    }
}
