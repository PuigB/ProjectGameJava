package Shop;

import Character.Character;
import Inventory.Item;
import Inventory.RecoveryItem.*;
import Inventory.Weapons.BasicHandsWrap;
import Inventory.Weapons.BasicShinGuard;
import Inventory.Weapons.BasicSyntheticGloves;
import Inventory.Weapons.BlackPandaGloves;
import Log.Logger;

import java.util.Vector;

public class Shop {
    private final Vector<Item> m_Shop_Items_List = new Vector<>();
    private static Shop m_Shop; // private because it is an attribute, static because it need to be usable even if the class isn't instanced yet


    public enum category {
        Weapons,
        Recovery_Item
    }

    /***
     * Getter
     */
    public static Shop getShopInstance() {
        if (m_Shop == null)
        {
            m_Shop = new Shop();
        }
        return m_Shop;
    }

    public Vector<Item> getShop() {
        return m_Shop_Items_List;
    }

    /***
     * Setter
     */
    public void addItem(Item newItem) {
        m_Shop_Items_List.add(newItem);
    }

    /***
     * Methods
     */

    public boolean sellItem(Character perso ,Item item) {
         return perso.buyItem(item);
    }


    //singelton : instance qui ne peut pas etre dupliquée
    private Shop()
    {
        // recoveryItem
        this.m_Shop_Items_List.add(new Bandages());
        this.m_Shop_Items_List.add(new HemostaticPowder());
        this.m_Shop_Items_List.add(new IcePack());
        this.m_Shop_Items_List.add(new IsraeliEmergencyBandage());
        this.m_Shop_Items_List.add(new Oranges());

        // weapons
        this.m_Shop_Items_List.add(new BasicHandsWrap());
        this.m_Shop_Items_List.add(new BasicShinGuard());
        this.m_Shop_Items_List.add(new BasicSyntheticGloves());
        this.m_Shop_Items_List.add(new BlackPandaGloves());

        Logger.addLog("Shop initialized as singleton","Shop", Logger.LOG_LEVEL.DEBUG);
    }
}
