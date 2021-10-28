package Character;

import Inventory.Item;
import Inventory.Weapons.Weapons;
import Log.Logger;

import java.util.Vector;

public class Character
{
/***
 * Var
 */
    protected String m_Name;
    protected int m_LifePoint = 100;
    protected int m_Strength = 5;
    protected int m_Agility = 3;
    protected int m_Defense;
    private Vector<Item> m_Inventory = new Vector<Item>();
    private Weapons m_Weapons;


/***
 * Methods
 */
public void attack() {
   /** try {
        Clip clip = AudioSystem.getClip();
        AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                Main.class.getResourceAsStream("src/Ressources/Murlock.wav"));
        clip.open(inputStream);
        clip.start();
    } catch (Exception e) {
        System.err.println(e.getMessage());
    }**/

}
public void takeDamage(Character enemy) {
    int ProbabilityAgility = (int)(Math.random() * (100 + 1));
    if (ProbabilityAgility < m_Agility) {
        System.out.println("The enemy dodge the attack");
    } else {
        int ProbabilityStrength = (int)(Math.random() * (100 + 1));
        if (ProbabilityStrength < enemy.m_Strength) {
            m_LifePoint -= enemy.m_Weapons.getDamages() * 2;
            System.out.println("Critical damage, the target take : " + enemy.m_Weapons.getDamages() * 2);
        } else {
            m_LifePoint -= enemy.m_Weapons.getDamages();
            System.out.println("The target take : " + enemy.m_Weapons.getDamages());
        }
    }
}

public void recoveryItem()
{

}

public void switchWeapons()
{

}

public void counterAttack()
{

}

/***
 * Getter
 */
    public int getAgility() {
        return m_Agility;
    }
    public int getStrenght() {
        return m_Strength;
    }
    public int getLifePoint() {
        return m_LifePoint;
    }
    public int getDefense()
    {
        return m_Defense;
    }
    public Vector<Item> getInventory() {
        return m_Inventory;
    }
    public Weapons getWeapons() {
        return m_Weapons;
    }
/***
* Setter
*/
public void setLifePoint(int lifePoints)
{
    m_LifePoint = lifePoints;
}
    public void setAgility(int agility) {
        m_Agility = agility;
    }
    public void setStrenght(int strenght) {
        m_Strength = strenght;
    }
    public void setDefense(int defense)
    {
        m_Defense = defense;
    }
    public void setName(String Name){
    m_Name = Name;
        Logger.addLog("setName Character", m_Name, Logger.LOG_LEVEL.LOG);
    }
    public void setInventory(Item item) {
        m_Inventory.add(item);
    }
    public void setWeapons(Weapons weapons) {
        m_Weapons = weapons;
    }
}


