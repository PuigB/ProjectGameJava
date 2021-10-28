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
    protected int m_Defense = 10;
    private int m_Experience = 0;
    private Vector<Item> m_Inventory = new Vector<Item>();
    private Weapons m_Weapons;
    private int m_Level = 1;


/***
 * Methods
 */
public Character(String Name) {
    m_Name = Name;
}

public void attack(Character enemy, Character Attacker) {
   /** try {
        Clip clip = AudioSystem.getClip();
        AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                Main.class.getResourceAsStream("src/Ressources/Murlock.wav"));
        clip.open(inputStream);
        clip.start();
    } catch (Exception e) {
        System.err.println(e.getMessage());
    }**/
    enemy.takeDamage(Attacker);
}
public void takeDamage(Character Attacker) {
    int ProbabilityAgility = (int)(Math.random() * (100 + 1));
    if (ProbabilityAgility < m_Agility) {
        System.out.println("The enemy dodge the attack");
    } else {
        int ProbabilityStrength = (int)(Math.random() * (100 + 1));
        if (ProbabilityStrength < Attacker.m_Strength) {
            m_LifePoint -= ((Attacker.m_Weapons.getDamages() * 2) - (m_Defense / 10));
            System.out.println("Critical damage, the target take : " + Attacker.m_Weapons.getDamages() * 2);
        } else {
            m_LifePoint -= (Attacker.m_Weapons.getDamages() - (m_Defense /10));
            System.out.println(m_Name +" take " + Attacker.m_Weapons.getDamages() + " his defense blocked " + m_Defense /10 +" damage");
        }
    }
}

public void recoveryItem()
{

}

public void switchWeapons(Weapons newWeapons)
{
    m_Weapons = newWeapons;
}

public void counterAttack()
{

}

public void endCombat(Boolean win) {
    m_LifePoint = 100;
    // method for durability
    //m_Weapons.setDurability();
    // add exp
    setExperience(win);
    // elo + or -
}

public void Experience() {
//    if (m_Experience <= 120) {
//        m_Level = 1;
//    } else if (m_Experience > 120 && m_Experience <=240) {
//        m_Level = 2;
//        m_Agility = 4;
//        m_Strength = 6;
//    } else if ( m_Experience > 240 && m_Experience <= 480) {
//        m_Level = 3;
//        m_Agility = 6;
//        m_Strength = 8;
//    } else if ( m_Experience > 480 && m_Experience <= 960) {
//        m_Level = 4;
//        m_Agility = 8;
//        m_Strength = 10;
//    } else if (m_Experience > 960 && m_Experience <= 1920){
//        m_Level = 5;
//        m_Agility = 10;
//        m_Strength = 12;
//    }
}

/***
 * Getter
 */
    public int getAgility() {
        return m_Agility;
    }
    public int getStrength() {
        return m_Strength;
    }
    public int getLifePoint() {
        return m_LifePoint;
    }
    public int getDefense()
    {
        return m_Defense;
    }

    public int getExperience() {
        return m_Experience;
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
    this.m_LifePoint = lifePoints;
}
    public void setAgility(int agility) {
        this.m_Agility = agility;
    }
    public void setStrenght(int strenght) {
        this.m_Strength = strenght;
    }
    public void setDefense(int defense)
    {
        this.m_Defense = defense;
    }
    public void setName(String Name){
    this.m_Name = Name;
        Logger.addLog("setName Character", m_Name, Logger.LOG_LEVEL.LOG);
    }

    public void setExperience(boolean win) {
        if (win) {
            this.m_Experience += 40;
        } else {
            this.m_Experience += 13;
        }

    }

    public void setInventory(Item item) {
        this.m_Inventory.add(item);
    }
    public void setWeapons(Weapons weapons) {
        this.m_Weapons = weapons;
    }
}


