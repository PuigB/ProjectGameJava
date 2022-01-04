package Inventory.Weapons;

import Log.Logger;

public class BlackPandaGloves extends Weapons {

    /**
     * Constructor
     */
    public BlackPandaGloves()
    {
        super(50,0,false,1,100,3, "Black Panda Gloves");
        super.setType(item_type.Weapon);
        super.setPrice(1500);
        Logger.addLog("BlackPandaGloves as been create","BlackPandaGloves", Logger.LOG_LEVEL.DEBUG);
    }

    /***
     * Attribute
     */
    private String m_Name = "Gant Black Panda(Yokkao)";
    private float m_Price = 700;

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
