public class Witch extends HealClass{
//   private Integer blessOfProtection;

   public Witch(String className, Integer level, double health, double healthMax, Integer attack, Integer damageMin, Integer damageMax, Integer defense, Integer speed, Integer mana) {
      super(className, level, health, healthMax, attack,  damageMin, damageMax, defense, speed, mana);
   }
   @Override
   public String toString() {
      return "Witch{" +
              "className='" + className + '\'' +
              ", level=" + level +
              '}';
   }
   @Override
   protected void heal(BaseClass unit) {
      if(mana >= 10) {
         super.heal(unit);
         unit.defense = blessOfProtection(unit);
         mana -= 10;
      }
   }
   protected Integer blessOfProtection(BaseClass unit){
      if((Math.random()*(100 - 1) + 1)<=50){
         unit.defense = unit.defense * 2;
      }
      return unit.defense;
   }
}
