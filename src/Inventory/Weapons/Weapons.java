package Inventory.Weapons;

import Inventory.Item;

public class Weapons extends Item
{
    /***
     * Attributes
     */
    private int m_Damages;
    private int m_Durability;

    /***
     * Methods
     */

    /***
     * Getter
     */
    public void setDurability(int durability)
    {
         m_Durability = durability;
    }
    public void setDamages(int damages)
    {
        m_Damages = damages;
    }

    /***
     * Setter
     */

    public int getDamages()
    {
        return m_Damages;
    }
    public int getDurability()
    {
        return m_Durability;
    }
}
