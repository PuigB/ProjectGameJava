package Character;
import Game.GameObject;
import com.sun.tools.javac.Main;

import javax.sound.sampled.*;
import java.io.IOException;

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
}


