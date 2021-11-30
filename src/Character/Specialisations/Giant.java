package Character.Specialisations;

import Character.Character;
import Log.Logger;

public class Giant extends Character {

    public Giant(String Name) {
        super(Name);
        super.setType("Giant");
        super.setLifePoint(150);
        super.setAttack(10);
        super.setStrenght(10);
        super.setAgility(2);
        super.setDefense(8);
        Logger.addLog("Giant as been create","Giant", Logger.LOG_LEVEL.DEBUG);
    }

}
