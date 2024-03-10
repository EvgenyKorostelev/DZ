
public class Main {
    public static void main(String[] args) {
        Peasant peasant = new Peasant("Peasant", 1,90.0, 90.0, 1, 1, 1, 1, 1, 3);

        Sniper sniper = new Sniper("Sniper", 1, 200.0, 200.0, 5, 30, 50, 3, 4 , 10);
        Crossbowman crossbowman = new Crossbowman("Crossbowman", 1, 220.0, 220.0, 4, 1, 4, 4, 3, 10);
        Pikeman pikeman = new Pikeman("Pikeman", 1, 300.0, 300.0, 3, 1, 3, 8, 3, 2);
        Rogue rogue = new Rogue("Rogue",1,280.0, 280.0, 4, 40, 60, 7, 3, 2);
        Monk monk = new Monk("Monk",1,140.0, 140.0, 6, 60, 80, 2, 2, 105);
        Witch witch = new Witch("Witch", 1, 160.0, 160.0, 5, 20, 70, 2, 2, 95);


        System.out.println(peasant);
        System.out.println(sniper);
        System.out.println(crossbowman);
        System.out.println(pikeman);
        System.out.println(rogue);
        System.out.println(monk);
        System.out.println(witch);


        sniper.attackDamage(pikeman);
        System.out.println(pikeman.getHealth());
        rogue.attackDamage(pikeman);
        System.out.println(pikeman.getHealth());

        witch.heal(pikeman);
        System.out.println(pikeman.getHealth());
        System.out.println();
        sniper.attackDamage(rogue);
        System.out.println(rogue.getHealth());


    }
}
