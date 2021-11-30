package Inventory.Weapons;
import Character.IPersonnage;
import Inventory.Weapons.IArme;
import Inventory.Weapons.Weapons;

public class BasicShinGuard extends Weapons {

    /**
     * Constructor
     */
    public BasicShinGuard()
    {
        super(1,0,false,1,100);
    }

    /***
     * Attribute
     */
    private String m_Name = "Gant Synthétique";

    /***
     * Methods
     */

    /***
     * Getter
     */

    public String getName()
    {
        return m_Name;
    }
}
