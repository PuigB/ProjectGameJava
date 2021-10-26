package Character;

import Log.Logger;

public class Character
{
/***
 * Var
 */
    protected String m_Name;
    protected int m_LifePoint;
    protected int m_Strength;
    protected int m_Agility;
    protected int m_Defense;

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
}


