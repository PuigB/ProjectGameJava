package Character;
import Game.GameObject;
public class Character extends GameObject
{
/***
 * Var
 */

    protected int m_LifePoint;
    protected int m_Strength;
    protected int m_Agility;
    protected int m_Defense;

/***
 * Methods
 */
public void attack()
{

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

    public String getName() {
        return m_Name;
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
public void setName(String name)
{
    m_Name = name;
}
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
}


