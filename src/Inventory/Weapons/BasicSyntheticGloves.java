package Inventory.Weapons;

import Log.Logger;

public class BasicSyntheticGloves extends Weapons {

    /**
     * Constructor
     */
    public BasicSyntheticGloves()
    {
        super(10,0,false,1,100,1, "Basic Synthetic Gloves");
        super.setType(item_type.Weapon);
        super.setPrice(150);
        Logger.addLog("BasicSyntheticGloves as been create","BasicSyntheticGloves", Logger.LOG_LEVEL.DEBUG);
    }

    /***
     * Attribute
     */
    private String m_Name = "Basic Synthetic Gloves";
    private float m_Price = 50;

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


