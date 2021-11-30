package Inventory.Weapons;

import Inventory.Item;
import Character.*;
import Log.Logger;

public abstract class Weapons extends Item implements IArme
{
    /***
     * constructor
     */
    public Weapons(float Damages,float Usure,boolean isEquiped,float Weight,float Precision)
    {
        this.m_Damages = Damages;
        this.m_Usure = Usure;
        this.m_isEquiped=isEquiped;
        this.m_Weight=Weight;
        this.m_Precision=Precision;
        Logger.addLog("the weapon as been create","weapons", Logger.LOG_LEVEL.DEBUG);
    }
    /***
     * Attributes
     */
    protected float m_Damages;
    protected float m_Usure;
    protected boolean m_isEquiped;
    protected final float m_Weight;
    protected float m_Precision;
    /***
     * Methods
     */

    /***
     * Getter
     */
    public float setUsure(float usure)
    {
        return m_Usure = usure;
    }
    public float setDamages(float damages)
    {
        return m_Damages = damages;
    }
    public void repair(float percent) {
        m_Usure = 0;
    }
    public void setIsEquiped(boolean equiped) {
        m_isEquiped = equiped;
    }
    public void setPrecision(float Precision) {
        m_Precision = Precision;
    }

    /***
     * Setter
     */
    public float getDamages()
    {
        return m_Damages;
    }
    public void getUsure(float usure)
    {
        m_Usure = usure;
    }
    public boolean isEquipped() {
        return m_isEquiped;
    }
    public float getUsure() {
        return m_Usure;
    }
    public float getWeight() {
        return m_Weight;
    }
    public float getDamage() {
        return m_Damages;
    }
    public float getPrecision() {
        return m_Precision;
    }
    public float getRange() {
        return 0;
    }
    public void attack(IPersonnage target) {}
}
