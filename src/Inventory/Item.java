package Inventory;

/***
 * Attributes
 */

public class Item {
    protected String m_Name;
    protected int m_Mass;
    protected item_type m_Type;
    protected float m_Durability;
    protected int m_Level;
    protected float m_Price;


    /***
     * Methods
     */

    /***
     * enum
     */
    public enum item_type {
        RecoveryItem,
        Weapon,
    }
    /***
     * Getter
     */
    public int getMass() {
        return m_Mass;
    }

    public item_type getType() {
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

    public void setType(item_type Type) {
        m_Type = Type;
    }

    public void setName(String Name) {
        m_Name = Name;
    }

    public void setDurabilityItem(float Durability) {
        m_Durability = Durability;
    }

    public void setLevel(int Level) {
        m_Level = Level;
    }

    public void setPrice(float Price) {
        m_Price=Price;
    }
}
