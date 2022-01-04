package Inventory.Weapons;
import Character.IPersonnage;
import Inventory.Weapons.IArme;
import Inventory.Weapons.Weapons;
import Log.Logger;

public class BasicHandsWrap extends Weapons {

    /**
     * Constructor
     */
    public BasicHandsWrap()
    {
        super(25,0,false,1,100,1,"Basic Hands Wraps");
        super.setType(item_type.Weapon);
        super.setPrice(250);
        Logger.addLog("BasicHandsWraps as been created","BasicHandWraps", Logger.LOG_LEVEL.DEBUG);
    }

    /***
     * Attribute
     */
    private String m_Name = "BasicHandsWrap";

    /***
     * Getter
     */
    public float getPrice() { return m_Price;}
    public String getName()
    {
        return m_Name;
    }
}