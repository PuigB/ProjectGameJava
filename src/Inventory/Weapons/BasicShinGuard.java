package Inventory.Weapons;

import Character.IPersonnage;
import Inventory.Weapons.IArme;
import Inventory.Weapons.Weapons;
import Log.Logger;

public class BasicShinGuard extends Weapons {

    /**
     * Constructor
     */
    public BasicShinGuard()
    {
        super(35,0,false,1,100, 2, "Gant Synthétique");
        super.setType(item_type.Weapon);
        super.setPrice(500);
        Logger.addLog("BasicShinGuard as been create","BasicSyntheticGloves", Logger.LOG_LEVEL.DEBUG);
    }

    private String m_Name = "Gant Synthétique";
    /***
     * Attribute
     */

    /***
     * Methods
     */

    /***
     * Getter
     */

    public float getPrice() { return m_Price;}

    public String getName()
    {
        return m_Name;
    }
}
