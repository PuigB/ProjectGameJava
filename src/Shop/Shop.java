package Shop;

import java.util.Vector;

import Game.Game;
import Inventory.Weapons.Weapons;
import Inventory.RecoveryItem.RecoveryItem;
import Inventory.Item;
import Log.Logger;
import Character.Character;

public class Shop {
    private Vector<Weapons> m_Shop_Items_List;
    private Vector<RecoveryItem> m_Shop_RecoveryItem;
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

    public Vector<Weapons> show_Weapons(Character perso) {
        Vector<Weapons> result = new Vector<Weapons>();
        for (Weapons item : m_Shop_Items_List) {
            if (item.getLevel() >= perso.getLvl()-1 && item.getLevel() < perso.getLvl()+1) {
                item.setPrice(item.getPrice()*(1+(float)perso.getLvl()/10));
                result.add(item);

            }
        }
        return result;
    }
    public Vector<RecoveryItem> show_Recovery_Item(Character perso){
        return m_Shop_RecoveryItem;
    }

    public Vector<String> showItem(Character perso, category choice) {
        Vector<String> result = new Vector<>();
        switch (choice) {
            case Weapons:
                for (Item item : show_Weapons(perso)) {
                    result.add(item.getName());
                }

                break;
            case Recovery_Item:
                for (Item item : show_Recovery_Item(perso)) {
                    result.add(item.getName());
                }
                break;
        }
        return result;
    }

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

    public boolean sellItem(Character perso ,category choice, Weapons item) {
        return perso.buyItem(item);
    }

    //singelton : instance qui ne peut pas etre dupliquée
    private Shop()
    {
        Logger.addLog("Shop initialized as singleton","Shop", Logger.LOG_LEVEL.DEBUG);
    }
}
