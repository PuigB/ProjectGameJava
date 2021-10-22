package Inventory;
import Game.GameObject;
/***
 * Attributes
 */
public class Item extends GameObject {
    protected int m_Mass;
    protected String m_Type;
    protected float m_Durability;
    protected int m_Level;
    protected float m_Price;

    /***
     * Methods
     */


    /***
     * Getter
     */
    public int getMass() {
        return m_Mass;
    }

    public String getType() {
        return m_Type;
    }

    public String getName() {
        return m_Name;
    }

    public float getDurability() {
        return m_Durability;
    }

    public int getLevel() {
        return m_Level;
    }

    public float getPrice() {
        return m_Price;
    }
    /***
     * Setter
     */
    public void setMass(int Mass) {
        m_Mass = Mass;
    }

    public void setType(String Type) {
        m_Type = Type;
    }

    public void setName(String Name) {
        m_Name = Name;
    }

    public void setDurability(float Durability) {
        m_Durability = Durability;
    }

    public void setLevel(int Level) {
        m_Level = Level;
    }

    public void setPrice(float Price) {
        m_Price=Price;
    }
}
