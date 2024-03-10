public class Peasant extends BaseClass {
    private Integer fatigue;


    public Peasant(String className, Integer level, double health, double healthMax, Integer defense, Integer speed, Integer attack, Integer damageMin, Integer damageMax, Integer fatigue) {
        super(className, level, health, healthMax, defense, speed, attack, damageMin, damageMax);
        this.fatigue = fatigue;
    }
    @Override
    public String toString() {
        return "Peasant{" +
                "className='" + className + '\'' +
                ", level=" + level +
                '}';
    }
}
