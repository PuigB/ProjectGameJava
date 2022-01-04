package Shop;

import java.util.Vector;

import Game.Game;
import Inventory.Weapons.Weapons;
import Inventory.RecoveryItem.RecoveryItem;
import Log.Logger;
import Character.Character;
import javax.management.ValueExp;

public class Shop {
    private Vector<Weapons> m_Shop_Items_List;
    private Vector<RecoveryItem> m_Shop_RecoveryItem;
    private static Shop m_Shop; // private because it is an attribute, static because it need to be usable even if the class isn't instanced yet


    public enum category {
        Weapons,
        Shared_Weapons,
        Recovery_Item
    }
    /***
     * Getter
     */
    public static Shop getGameInstance() {
        if (m_Shop == null)
        {
            m_Shop = new Shop();
        }
        return m_Shop;
    }

    /*private Vector selectItems(category choice) {
        switch (choice){
            case Weapons ->
        }
    }*/

    /*public <T> Vector<T> showItem(Character perso, category choice) {
        Vector<Weapons> result = new Vector<>();

        switch (choice) {
            case Weapons:
                for (Weapons item : m_Shop_Items_List) {
                    if (item.getLevel() >= perso.getLvl()-1 && item.getLevel() < perso.getLvl()+1) {
                        item.setPrice(item.getPrice()*(1+(float)perso.getLvl()/10));
                        result = new Vector<Weapons>();
                        result.add(item);
                    }
                }
                break;
            case Shared_Weapons:
                for (weapon item : m_Shop_SharedWeapons) {
                       // result.add(item);

                }
                break;
            case Recovery_Item:
                for (RecoveryItem item : m_Shop_RecoveryItem) {
                    // result.add(item);

                }
                break;
        }

        return result;
    }*/

    public Vector<Weapons> getShop() {
        return m_Shop_Items_List;
    }

    /***
     * Setter
     */
    public void addItem(Weapons newItem) {
        m_Shop_Items_List.add(newItem);
    }

    /***
     * Methods
     */

    public boolean sellItem(Character perso ,Weapons item) {
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
