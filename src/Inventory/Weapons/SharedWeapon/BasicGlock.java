package Inventory.Weapons.SharedWeapon;

import Inventory.Weapons.Weapons;
import Log.Logger;

public class BasicGlock extends weapon {
public BasicGlock() {
    super(5, 100, false, 5, 80,60);
    Logger.addLog("Basic Glock has been created","Weapons", Logger.LOG_LEVEL.DEBUG);
}
    private String name = "Glock";
}

