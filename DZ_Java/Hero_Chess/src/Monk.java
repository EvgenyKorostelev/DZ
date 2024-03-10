public class Monk extends HealClass{
//   private Integer blessOfFanaticism;

   public Monk(String className, Integer level, double health, double healthMax, Integer attack, Integer damageMin, Integer damageMax, Integer defense, Integer speed, Integer mana) {
      super(className, level, health, healthMax, attack, damageMin, damageMax, defense, speed, mana);
   }
   @Override
   public String toString() {
      return "Monk{" +
              "className='" + className + '\'' +
              ", level=" + level +
              '}';
   }
   @Override
   protected void heal(BaseClass unit) {
      if (mana >= 15) {
         super.heal(unit);
         unit.attack = blessOfFanaticism(unit);
         mana -= 15;
      }
   }
   protected Integer blessOfFanaticism(BaseClass unit){
      if((Math.random()*(100 - 1) + 1)<=40){
         unit.attack = unit.attack * 2;
      }
      return unit.attack;
   }
}
