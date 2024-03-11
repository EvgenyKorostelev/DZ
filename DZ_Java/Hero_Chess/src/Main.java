import mainclasses.*;

public class Main {
    public static void main(String[] args) {
        Peasant peasant = new Peasant();
        Sniper sniper = new Sniper();
        Crossbowman crossbowman = new Crossbowman();
        Pikeman pikeman = new Pikeman();
        Rogue rogue = new Rogue();
        Monk monk = new Monk();
        Witch witch = new Witch();

        System.out.println(peasant);
        System.out.println(sniper);
        System.out.println(crossbowman);
        System.out.println(pikeman);
        System.out.println(rogue);
        System.out.println(monk);
        System.out.println(witch);
        System.out.println();


        sniper.attackDamage(pikeman);
        System.out.println(pikeman.getHealth());
        rogue.attackDamage(pikeman);
        System.out.println(pikeman.getHealth());
        witch.heal(pikeman);
        System.out.println(pikeman.getHealth());
        sniper.attackDamage(rogue);
        System.out.println(rogue.getHealth());
        peasant.attackDamage(witch);
        System.out.println(witch.getHealth());
    }
}
