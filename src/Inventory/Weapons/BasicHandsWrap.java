package Inventory.Weapons;
import Character.IPersonnage;
import Inventory.Weapons.IArme;
import Inventory.Weapons.Weapons;
import Log.Logger;

class BasicHandsWrap extends Weapons {

    /**
     * Constructor
     */
    public BasicHandsWrap()
    {
        super(1,0,false,1,100,1);
        Logger.addLog("BasicHandsWraps as been create","BasicHandWraps", Logger.LOG_LEVEL.DEBUG);
    }

    /***
     * Attribute
     */
    private String m_Name = "Gant Synthétique";

    /***
     * Getter
     */

    public String getName()
    {
        return m_Name;
    }
}