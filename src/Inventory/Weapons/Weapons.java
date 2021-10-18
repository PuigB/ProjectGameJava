package Inventory.Weapons;

import Game.GameObject;

public class Weapons extends GameObject
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
    public int setDurability(int durability)
    {
        return m_Durability = durability;
    }
    public int setDamages(int damages)
    {
        return m_Damages = damages;
    }

    /***
     * Setter
     */

    public void getDamages(int damages)
    {
        m_Damages = damages;
    }
    public void getDurability(int durability)
    {
        m_Durability = durability;
    }
}
