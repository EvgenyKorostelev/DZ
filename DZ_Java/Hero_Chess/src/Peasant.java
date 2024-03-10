public class Peasant extends Workers {
//    private Integer returnArrows;

    public Peasant(String className, Integer level, double health, double healthMax, Integer defense, Integer speed, Integer attack, Integer damageMin, Integer damageMax, Integer fatigue) {
        super(className, level, health, healthMax, defense, speed, attack, damageMin, damageMax, fatigue);
    }
    @Override
    public String toString() {
        return "Peasant{" +
                "className='" + className + '\'' +
                ", level=" + level +
                '}';
    }

}
