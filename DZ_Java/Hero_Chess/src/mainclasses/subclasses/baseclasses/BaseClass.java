package mainclasses.subclasses.baseclasses;


import java.util.ArrayList;
import java.util.Random;

//Базовый класс для всех типов инитов
public abstract class BaseClass implements IMove{
//    protected String buff;
//    protected String deBuff;
    protected String name;
    protected Integer level;
    protected Point unitpoint;
    protected double health;
    protected double healthMax;
    protected Integer defense;
    protected Integer speed;
    protected Integer attack;
    protected Integer damageMin;
    protected Integer damageMax;
    protected boolean die;
    protected String team;
    //Конструкторы
    protected BaseClass(String name, Integer level, Point unitpoint, double health, double healthMax,
                        Integer defense, Integer speed, Integer attack, Integer damageMin, Integer damageMax, boolean die, String team) {
        this.name = name;
        this.level = level;
        this.unitpoint = unitpoint;
        this.health = health;
        this.healthMax = healthMax;
        this.defense = defense;
        this.speed = speed;
        this.attack = attack;
        this.damageMin = damageMin;
        this.damageMax = damageMax;
        this.die = die;
        this.team = team;

    }
    protected BaseClass(int x, int y, String team){
        this(randomName(), 99, new Point(x, y, 10),999, 999, 999, 999, 999, 999, 999,false, "нет");
    }
    protected BaseClass() {
        this(randomName(), 99,  new Point(),999, 999, 999, 999, 999, 999, 999,false, "нет");
    }
    //Список стандартных имен
    public enum Names {
        Один, Тор, Локи, Мимир, Фригг, Сиф, Идунн, Бальдр, Хеймдалль, Тюр, Хёнир, Браги, Улль, Нанна;
    }
    //Метод извлечения имени из стандартных
    protected static String randomName() {
        return String.valueOf(Names.values()[new Random().nextInt(Names.values().length)]);
    }
    //Метод поиска ближайшего противника
    public BaseClass findTarget(ArrayList<BaseClass> units){
        double minDistance = Double.MAX_VALUE;
        BaseClass target = units.getFirst();
        for (BaseClass unit : units) {
            if(!unit.die) {
                double temp = unitpoint.distanceTo(unit.getUnitpoint());
                if (temp < minDistance) {
                    minDistance = temp;
                    target = unit;
                }
            }
        }
        return target;
    }
    //Метод нанесения урона противнику
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
        if (unit.defense != 100) {
            unit.health = unit.health - dmg * hI;
            if(unit.health <= 0) {unit.die = true;}
        }

    }
    //Метод исцеления союзника
    public void heal(BaseClass unit) {
        double heal = Math.random() * (damageMax - damageMin) + damageMin;
        if (unit.health < unit.healthMax) {
            unit.health = unit.health + heal;
        }
        if (unit.health >= unit.healthMax) {
            unit.health = unit.healthMax;
        }
    }
    //Гетеры и сетеры
    public String getName() {
        return name;
    }
    public Integer getLevel() {
        return level;
    }
    public Point getUnitpoint() {
        return unitpoint;
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
    public Integer getDamageMin() {return damageMin;}
    public Integer getDamageMax() {return damageMax;}
    public boolean getDie() {return die;}
    public String getTeam() {
        return team;
    }

    public void setHealth(double health) {
        this.health = health;
    }
    public void setUnitpoint(Point unitpoint) {
        this.unitpoint = unitpoint;
    }
    public void setDefense(Integer defense) {
        this.defense = defense;
    }
    public void setAttack(Integer attack) {
        this.attack = attack;
    }
    public void setDie(boolean die) {
        this.die = die;
    }
}
