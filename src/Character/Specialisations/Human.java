package Character.Specialisations;

import Character.Character;
import Log.Logger;

public class Human extends Character {

    public Human(String Name) {
        super(Name);
        super.setType("Human");
        super.setLifePoint(100);
        super.setAttack(7);
        super.setStrenght(7);
        super.setAgility(6);
        super.setDefense(6);
        Logger.addLog("Human as been create","Human", Logger.LOG_LEVEL.DEBUG);
    }

    @Override
    public void takeDamage() {
        System.out.println("La calotte de tes m...");
    }

}