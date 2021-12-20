package Inventory.Weapons;

import Character.IPersonnage;
import Inventory.Weapons.IArme;
import Inventory.Weapons.Weapons;
import Log.Logger;

public class BasicSyntheticGloves extends Weapons {

    /**
     * Constructor
     */
    public BasicSyntheticGloves()
    {
        super(1,0,false,1,100,1);
        Logger.addLog("BasicSyntheticGloves as been create","BasicSyntheticGloves", Logger.LOG_LEVEL.DEBUG);
    }

    /***
     * Attribute
     */
    private String m_Name = "Gant Synthétique";
    private float m_Price = 100;

    /***
     * Methods
     */

    /***
     * Setter
     */
    public void setPrice(float price)
    {
        m_Price=price;
    }

    /***
     * Getter
     */

    public String getName()
    {
        return m_Name;
    }
    public float getPrice() { return m_Price;}
}


