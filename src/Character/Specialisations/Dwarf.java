package Character.Specialisations;

import Character.Character;
import Log.Logger;

public class Dwarf extends Character {

    public Dwarf(String Name) {
        super(Name);
        super.setType("Dwarf");
        super.setLifePoint(80);
        super.setAttack(6);
        super.setStrenght(6);
        super.setAgility(10);
        super.setDefense(10);
        Logger.addLog("Dwarf as been create","Dwarf", Logger.LOG_LEVEL.DEBUG);
    }

}