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
    protected String combatLog;
    //Конструкторы
    protected BaseClass(String name, Integer level, Point unitpoint, double health, double healthMax,
                        Integer defense, Integer speed, Integer attack, Integer damageMin, Integer damageMax, boolean die, String team, String combatLog) {
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
        this.combatLog = combatLog;

    }
    protected BaseClass(int x, int y, String team){
        this(randomName(), 99, new Point(x, y, 10),999, 999, 999, 999, 999, 999, 999,false, "нет", "");
    }
    protected BaseClass() {
        this(randomName(), 99,  new Point(),999, 999, 999, 999, 999, 999, 999,false, "нет", "");
    }
    //Списки стандартных имен
    public enum Names {
        Один, Тор, Локи, Мимир, Фригг, Сиф, Идунн, Бальдр, Хеймдалль,
        Тюр, Хёнир, Браги, Улль, Нанна, Зевс, Гера, Посейдон, Аид, Деметра,
        Гестия, Афина, Персефона, Афродита, Гефест, Гермес, Аполлон, Арес,
        Артемида, Дионис, Гандаш, Агум, Шушши, Кандалану, Саргон, Набонид,
        Навуходоносор, Валтасар, Тиглатпаласар, Синаххериб, Набополассар
    }
    public enum NamesH {
        Один, Тор, Локи, Мимир, Фригг, Сиф, Идунн, Бальдр, Хеймдалль,
        Тюр, Хёнир, Браги, Улль, Нанна
    }
    public enum NamesA {
        Зевс, Гера, Посейдон, Аид, Деметра, Гестия, Афина, Персефона,
        Афродита, Гефест, Гермес, Аполлон, Арес, Артемида, Дионис
    }
    public enum NamesW {
        Гандаш, Агум, Шушши, Кандалану, Саргон, Набонид, Навуходоносор,
        Валтасар, Тиглатпаласар, Синаххериб, Набополассар
    }
    //Методы извлечения имени из стандартных
    protected static String randomName() {
        return String.valueOf(Names.values()[new Random().nextInt(Names.values().length)]);
    }
    protected static String randomNameH() {
        return String.valueOf(NamesH.values()[new Random().nextInt(NamesH.values().length)]);
    }
    protected static String randomNameA() {
        return String.valueOf(NamesA.values()[new Random().nextInt(NamesA.values().length)]);
    }
    protected static String randomNameW() {
        return String.valueOf(NamesW.values()[new Random().nextInt(NamesW.values().length)]);
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

        unit.health = unit.health - Math.abs(dmg * hI);
        if(unit.health <= 0) {unit.die = true;}
    }
    //Метод исцеления союзника
    public void heal(BaseClass unit) {
        double heal = Math.random() * (damageMax - damageMin) + damageMin;
        unit.health = unit.health + heal;
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
    public double getHealthMax() {return healthMax;}
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
    public String getTeam() {return team;}

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
