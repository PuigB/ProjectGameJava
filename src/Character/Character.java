package Character;

import Inventory.RecoveryItem.RecoveryItem;
import Inventory.Weapons.*;
import Inventory.Item;
import Log.Logger;
import java.util.Objects;
import java.util.Scanner;
import java.util.Vector;

public class Character implements IPersonnage
{
    /***
     * members
     */
    protected String m_Name;
    protected String m_Type;
    protected float m_LifePoint;
    protected float m_Attack;
    protected int m_Strength;
    protected int m_Agility;
    protected float m_Defense;
    private int m_Experience = 0;
    private Vector<Item> m_Inventory = new Vector<>();
    private Weapons m_Weapons;
    private int m_Level = 1;
    private float m_Bank = 0;
    private int x;
    private int y;
    private float m_MaxHealth;


    /**
     * Methods
     */

    public void useRecoveryItem(RecoveryItem item)
    {
        if (this.getHp() + item.regeneration() > this.getMaxHealth()){
            this.setLifePoint((int)this.getMaxHealth());
        } else {
            setLifePoint((int) (this.getHp() + item.regeneration()));
        }
        System.out.format("You consumed %s and it give you %d HP.", item.getName(),item.regeneration());
        m_Inventory.removeIf(m -> Objects.equals(m.getName(), item.getName()));
        System.out.println("Press Enter to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
    public Character(String Name) {
        m_Name = Name;
        m_Weapons = new BasicSyntheticGloves();
        m_Bank = 100;
        m_Level = 1;
        Logger.addLog(" Character as been create","Character", Logger.LOG_LEVEL.DEBUG);
    }
    public void attack(IPersonnage target) {
        /** try {
         Clip clip = AudioSystem.getClip();
         AudioInputStream inputStream = AudioSystem.getAudioInputStream(
         Main.class.getResourceAsStream("src/Ressources/Murlock.wav"));
         clip.open(inputStream);
         clip.start();
         } catch (Exception e) {
         System.err.println(e.getMessage());
         }**/
        float range =  this.getMainWeapon().getRange();
        int targetX = target.getX() > 0 ? target.getX() : target.getX() * (-1);
        int targetY = target.getY() > 0 ? target.getY() : target.getY() * -1;

        if (this.x + range >= target.getX() && this.y + range >= target.getY()) {
            float futureDamage = this.m_Attack + this.m_Weapons.getDamage();
                    int ProbabilityStrength = (int)(Math.random() * (100. + 1));
                    if (ProbabilityStrength < this.m_Strength) {
                        futureDamage += 5;
                    }
                    target.defense(this,this.m_Weapons,futureDamage);
        } else {
            System.out.format("%s: Out of range", target.getName());
        }
    }
    public void defense(IPersonnage Attacker,IArme weapon ,float damage){
        int ProbabilityAgility = (int)(Math.random() * (100 + 1));
        //System.out.println(ProbabilityAgility);
        if (ProbabilityAgility <= this.getAgility()) {
            System.out.println("The enemy dodge the attack");
        } else {
            if (damage > weapon.getDamage() + Attacker.getAttack()) {
                System.out.println("Critical damage : " + damage);
            }
            this.m_LifePoint -= damage;
            takeDamage();
        }

    }
    public void endCombat(Boolean win) {
        regenAfterFight();
        // method for durability
        // m_Weapons.setDurability();
        setExperience(win);
        Experience();

        // elo + or -
    }
    public void Experience() {
    if (m_Experience <= 120) {
        m_Level = 1;
    } else if (m_Experience > 120 && m_Experience <=240) {
        if (this.m_Level != 2) {
            this.m_Level = 2;
            this.m_Agility += 1;
            this.m_Strength += 1;
            this.setMaxHealth(1.5F);
            this.setLifePoint((int) Math.floor(this.getMaxHealth()));
            System.out.println("You are now level 2");
        }

    } else if ( m_Experience > 240 && m_Experience <= 480) {
        if (this.m_Level != 3) {
            this.m_Level = 3;
            this.m_Agility += 2;
            this.m_Strength += 2;
            this.setMaxHealth(1.5F);
            this.setLifePoint((int) Math.floor(this.getMaxHealth()));
            System.out.println("You are now level 3");
        }
    } else if ( m_Experience > 480 && m_Experience <= 960) {
        if (this.m_Level != 4) {
            m_Level = 4;
            m_Agility += 3;
            m_Strength += 3;
            this.setMaxHealth(1.5F);
            this.setLifePoint((int) Math.floor(this.getMaxHealth()));
            System.out.println("You are now level 4");
        }

    } else if (m_Experience > 960 && m_Experience <= 1920){
        if (this.m_Level != 5) {
            m_Level = 5;
            m_Agility += 3;
            m_Strength += 3;
            this.setMaxHealth(1.5F);
            this.setLifePoint((int) Math.floor(this.getMaxHealth()));
            System.out.println("You are now level 5");
        }
    }
    }

    public void setLvl(int level) {
        this.m_Level = level;
    }

    public void regenAfterFight() {
        if (Objects.equals(this.m_Type, "Giant")) {
            this.m_LifePoint = 150;
        } else if (Objects.equals(this.m_Type, "Dwarf")) {
            this.m_LifePoint = 80;
        } else {
            this.m_LifePoint = 100;
        }
    }
    public boolean buyItem(Item item) {
        if (this.m_Bank >= item.getPrice()) {
            this.setBank(this.getBank()-item.getPrice());
            this.m_Inventory.add(item);
            return true;
        }
        return false;
    }

    public void takeDamage() {
        System.out.format("%s: Ouch", this.getName());
    }


    /***
     * Getter
     */

    public String getName() {return m_Name;}
    public int getAgility() {
        return m_Agility;
    }
    public int getStrength() {
        return m_Strength;
    }
    public float getHp() {
        return m_LifePoint;
    }
    public float getDefense()
    {
        return m_Defense;
    }
    public float getAttack(){return m_Attack;}
    public int getExperience() {
        return m_Experience;
    }
    public IArme getMainWeapon(){return m_Weapons;}
    public String getType() {return m_Type;}
    public Vector<Item> getInventory() {
        return m_Inventory;
    }
    public int getLvl() { return m_Level;}
    public float getBank() {
        return m_Bank;
    }
    public int getX () {
        return x;
    }
    public int getY() {
        return y;
    }
    public float getMaxHealth(){ return m_MaxHealth;}


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
    public void setStrength(int strength) {
        this.m_Strength = strength;
    }
    public void setDefense(int defense)
    {
        this.m_Defense = defense;
    }
    public void setAttack(float attack) {
        this.m_Attack = attack;
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
    public void setType(String type) {
        this.m_Type = type;
    }
    public void setBank(float money) {
        this.m_Bank = money;
    }
    public void setInventory(Item item) {
        this.m_Inventory.add(item);
    }
    public void setWeapons(Weapons weapons) {
        if (this.m_Weapons == null) {
            this.m_Weapons = weapons;
            weapons.setIsEquiped(true);
        } else {
            this.m_Inventory.add(this.m_Weapons);
            this.m_Weapons.setIsEquiped(false);
            this.m_Weapons = weapons;
            weapons.setIsEquiped(true);
        }
    }
    public boolean setX(int x) {
        if (x < 10) {
            this.x = x;
            return true;
        } else {
            return false;
        }
    }
    public boolean setY(int y) {
        if (y < 10) {
            this.y = y;
            return true;
        } else {
            return false;
        }
    }
    public void setMaxHealth(float maxHealth)
    {
        this.m_MaxHealth = maxHealth;
    }

    public Vector<Item> getRecoveryItem() {
        Vector<Item> recoveryItem = new Vector<>();
        for (Item item : m_Inventory) {
            if (item.getType() == Item.item_type.RecoveryItem) {
                recoveryItem.add(item);
            }
        }
        return recoveryItem;
    }
}