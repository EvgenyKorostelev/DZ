public abstract class BaseClass {
//    protected String buff;
//    protected String deBuff;
    protected String className;
    protected Integer level;
    protected double health;
    protected double healthMax;
    protected Integer defense;
    protected Integer speed;
    protected Integer attack;
    protected Integer damageMin;
    protected Integer damageMax;

    public BaseClass(String className, Integer level, double health, double healthMax, Integer defense, Integer speed, Integer attack, Integer damageMin, Integer damageMax) {
        this.className = className;
        this.level = level;
        this.health = health;
        this.healthMax = healthMax;
        this.defense = defense;
        this.speed = speed;
        this.attack = attack;
        this.damageMin = damageMin;
        this.damageMax = damageMax;
    }

    protected void attackDamage(BaseClass unit){
        int i;
        int signI;
        int absI;
        double hI;
        double dmg = Math.random()*(damageMax - damageMin) + damageMin;
        i = attack - unit.defense;

        if(i<0) {signI = -1;}
        else if(i == 0) { signI = 0;}
        else {signI = 1;}

        if(i<0) {absI = -i;}
        else {absI = i;}

        hI = (1 + 0.1* Math.pow(0.1*signI,absI));
        if(unit.defense != 100)
            unit.health = unit.health - dmg * hI;
    }
    protected void heal(BaseClass unit) {
        double heal = Math.random()*(damageMax - damageMin) + damageMin;
        if (unit.health < unit.healthMax){
            unit.health = unit.health + heal;
        }
        if(unit.health >= unit.healthMax){
            unit.health = unit.healthMax;
        }
    }
    protected double getHealth(){
        return health;
    }
    protected int getAttack(){
        return attack;
    }
    protected int getDefense(){
        return attack;
    }
    protected String getClassName(BaseClass unit){
        return unit.className;
    }
    protected String getClassName(){
        return className;
    }

}
