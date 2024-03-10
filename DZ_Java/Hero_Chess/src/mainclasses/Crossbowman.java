package mainclasses;

import mainclasses.subclasses.RangeClass;
import mainclasses.subclasses.baseclasses.BaseClass;

public class Crossbowman extends RangeClass {
//  private Integer doubleShot;

  public Crossbowman(String name, Integer level, double health, double healthMax,
                     Integer attack, Integer damageMin, Integer damageMax, Integer defense,
                     Integer speed, Integer arrows, Integer arrowsMax) {
    super(name, level, health, healthMax, attack, damageMin, damageMax, defense, speed, arrows, arrowsMax);
  }
    public Crossbowman() {
        this(String.format("Crossbowman #%d", ++Crossbowman.num), 1, 200, 200,
                20, 15, 25, 20, 4, 10, 10);
    }
  @Override
  public String toString() {
    return "Crossbowman{" +
            "name='" + name + '\'' +
            ", level=" + level +
            '}';
  }
  @Override
  public void attackDamage(BaseClass unit) {
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

          if (doubleShot()) {
//                   if(range >= rangeMax / 2) //зависивость от расстояния до цели
              unit.health = unit.health - (dmg * hI) / 2;
              dmg = Math.random() * (damageMax - damageMin) + damageMin;//урон для второго выстрела
              unit.health = unit.health - (dmg * hI) / 2;
//                   else
//                       unit.health = unit.health - dmg * hI;
//                       dmg = Math.random()*(damageMax - damageMin) + damageMin;//урон для второго выстрела
//                       unit.health = unit.health - dmg * hI;
          } else
//                   if(range >= rangeMax / 2) //зависивость от расстояния до цели
//                       unit.health = unit.health - (dmg * hI) / 2;
//                   else
              unit.health = unit.health - dmg * hI;
          arrows -= 1;
    }
  }
  private boolean doubleShot(){
    return (Math.random() * (100 - 1) + 1) <= 30;
  }
}
