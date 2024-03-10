package mainclasses.subclasses.baseclasses;

import java.util.Random;

public abstract class BaseClass {
    protected static int num;
    protected static Random rnd;
    static {
        BaseClass.num = 0;
        BaseClass.rnd = new Random();
    }
//    protected String buff;
//    protected String deBuff;
    public String name;
    public Integer level;
    public double health;
    public double healthMax;
    public Integer defense;
    public Integer speed;
    public Integer attack;
    public Integer damageMin;
    public Integer damageMax;

    protected BaseClass(String name, Integer level, double health, double healthMax,
                        Integer defense, Integer speed, Integer attack, Integer damageMin, Integer damageMax) {
        this.name = name;
        this.level = level;
        this.health = health;
        this.healthMax = healthMax;
        this.defense = defense;
        this.speed = speed;
        this.attack = attack;
        this.damageMin = damageMin;
        this.damageMax = damageMax;

    }

    protected BaseClass() {
        this(String.format("Hero_Priest #%d", ++BaseClass.num), 99, 999, 999, 999, 999, 999, 999, 999);
    }

    public void attackDamage(BaseClass unit) {
        int i;
        int signI;
        int absI;
        double hI;
        double dmg = Math.random() * (damageMax - damageMin) + damageMin;
        i = attack - unit.defense;

        if (i < 0) {
            signI = -1;
        } else if (i == 0) {
            signI = 0;
        } else {
            signI = 1;
        }

        if (i < 0) {
            absI = -i;
        } else {
            absI = i;
        }

        hI = (1 + 0.1 * Math.pow(0.1 * signI, absI));
        if (unit.defense != 100)
            unit.health = unit.health - dmg * hI;
    }

    public void heal(BaseClass unit) {
        double heal = Math.random() * (damageMax - damageMin) + damageMin;
        if (unit.health < unit.healthMax) {
            unit.health = unit.health + heal;
        }
        if (unit.health >= unit.healthMax) {
            unit.health = unit.healthMax;
        }
    }

    public String getName() {
        return name;
    }

    public Integer getLevel() {
        return level;
    }

    public double getHealth() {
        return health;
    }

    public Integer getDefense() {
        return defense;
    }

    public Integer getSpeed() {
        return speed;
    }

    public int getAttack() {

        return attack;
    }

    public Integer getDamageMin() {
        return damageMin;
    }

    public Integer getDamageMax() {
        return damageMax;
    }
}
