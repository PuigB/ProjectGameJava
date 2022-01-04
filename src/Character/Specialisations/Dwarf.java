package Character.Specialisations;

import Character.Character;
import Log.Logger;

public class Dwarf extends Character {

    public Dwarf(String Name) {
        super(Name);
        super.setMaxHealth(80);
        super.setType("Dwarf");
        super.setLifePoint(80);
        super.setAttack(8);
        super.setStrength(6);
        super.setAgility(10);
        super.setDefense(10);
        Logger.addLog("Dwarf as been create","Dwarf", Logger.LOG_LEVEL.DEBUG);
    }

    @Override
    public void takeDamage() {
        System.out.println(": On ne tape pas les plus petits :'(");
    }

}