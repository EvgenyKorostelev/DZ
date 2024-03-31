package mainclasses.subclasses;

import mainclasses.subclasses.baseclasses.BaseClass;
import mainclasses.subclasses.baseclasses.Point;

import java.util.ArrayList;

//Класс обобщающий юнитов ближнего боя
public abstract class MeleeClass extends BaseClass {
    protected Integer stamina;
    protected Integer staminaMax;

    protected MeleeClass(String name, Integer level, Point unitpoint, double health, double healthMax,
                         Integer attack, Integer damageMin, Integer damageMax, Integer defense,
                         Integer speed, Integer stamina, Integer staminaMax, boolean die, String team, String combatLog) {
        super(name, level, unitpoint, health, healthMax, defense, speed, attack, damageMin, damageMax, die, team, combatLog);
        this.staminaMax = staminaMax;
        this.stamina = stamina;
    }

    @Override
    public void attackDamage(BaseClass unit) {
        super.attackDamage(unit);
    }
    //Метод передвижения персонажей ближнего боя
    public void moveTo(BaseClass target, ArrayList<BaseClass> allies) {
        int thisX = this.unitpoint.getCoordinateX();
        int thisY = this.unitpoint.getCoordinateY();
        int targetX = target.getUnitpoint().getCoordinateX();
        int targetY = target.getUnitpoint().getCoordinateY();
        Point newPlace = new Point(thisX, thisY);

        if ((Math.abs(targetX - thisX) > Math.abs(targetY - thisY))) {
            if (targetX - thisX > 0)
                newPlace.setCoordinateX(thisX + 1);
             else newPlace.setCoordinateX(thisX - 1);
        } else {
            if (targetY - thisY > 0)
                newPlace.setCoordinateY(thisY + 1);
            else newPlace.setCoordinateY(thisY - 1);
        }
        boolean flag = true;
        for (BaseClass unit : allies) {
            if (!this.equals(unit) && !unit.getDie() && (unit.getUnitpoint().equals(newPlace)))
                flag = false;
        }
        if(flag) this.setUnitpoint(newPlace);
    }

    @Override
    public void step(ArrayList<BaseClass> enemy, ArrayList<BaseClass> allies) {
        combatLog="";
        if (!this.die && enemy.stream().filter(BaseClass::getDie).count() < 10) {
            BaseClass target = this.findTarget(enemy);
            if (this.unitpoint.distanceTo(target.getUnitpoint()) < 2 && !target.getDie()) {
                double hpBefore = target.getHealth();
                this.attackDamage(target);
                double hpAfter = target.getHealth();
                this.combatLog = this.toString().charAt(0) + " " + this.name + " hit in: " + target.toString().charAt(0) + " " + target.getName() + " damage: " + (hpBefore - hpAfter);
            } else if (this.unitpoint.distanceTo(target.getUnitpoint()) >= 2 && !target.getDie()){
                Point positionBefore = this.unitpoint;
                this.moveTo(target, allies);
                Point positionAfter = this.unitpoint;
                this.combatLog = this.toString().charAt(0) + " " + this.name + " move to: " + target.toString().charAt(0) + " " + target.getName() + " " + positionBefore + " -> " + positionAfter;
            }
        }
    }

    public Integer getStamina() {
        return stamina;
    }

    public void setStamina(Integer stamina) {
        this.stamina = stamina;
    }
}
