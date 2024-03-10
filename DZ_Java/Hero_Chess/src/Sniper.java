public class Sniper extends RangeClass{
//   private Integer snipeShot;

   public Sniper(String className, Integer level, double health, double healthMax, Integer attack, Integer damageMin, Integer damageMax, Integer defense, Integer speed, Integer arrows) {
      super(className, level, health, healthMax, attack, damageMin, damageMax, defense, speed, arrows);
   }

   @Override
   public String toString() {
      return "Sniper{" +
              "className='" + className + '\'' +
              ", level=" + level +
              '}';
   }
   @Override
   protected void attackDamage(BaseClass unit) {
      if(arrows >= 1) {
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

         if (snipeShot())
            unit.health = unit.health - (dmg * hI) * 1.5;
         else
            unit.health = unit.health - dmg * hI;
         arrows -= 1;
      }
   }

   protected boolean snipeShot(){
      return (Math.random() * (100 - 1) + 1) <= 60;
   }
}
