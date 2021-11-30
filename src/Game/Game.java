package Game;
import Character.Specialisations.Dwarf;
import Character.Specialisations.Giant;
import Inventory.Weapons.BlackPandaGloves;
import Inventory.Weapons.SharedWeapon.BasicGlock;
import Inventory.Weapons.Weapons;
import Inventory.Weapons.SharedWeapon.weapon;
import  Log.Logger;
import Display.Display;

import java.io.DataInput;
import java.io.IOException;

public class Game
{
    /**
     * attribute
     */
    private static Game m_Game; // private because it is an attribute, static because it need to be usable even if the class isn't instanced yet

    /***
     * Getter
     */
    public static Game getGameInstance()
    {
        if (m_Game == null)
        {
            m_Game = new Game();
        }
        return m_Game;
    }

    //singelton : instance qui ne peut pas etre dupliquée
    private Game()
    {
        Logger.addLog("Game Object initialized as singleton","Game", Logger.LOG_LEVEL.DEBUG);
    }

    public void StartGame() throws Exception{

//       //Display d = new Display();
//        //d.Menu();
 //       //d.StartGame();
        Giant Enzo = new Giant("Enzo");
        weapon Glock = new BasicGlock();
        Enzo.setWeapons(Glock);
        Dwarf Baptiste = new Dwarf("Baptiste");
        Weapons Panda = new BlackPandaGloves();
        Baptiste.setWeapons(Panda);

        Enzo.attack(Baptiste);
        System.out.println(Baptiste.getHp());
        Baptiste.attack(Enzo);
        System.out.println(Enzo.getHp());
        System.out.println(Enzo.getMainWeapon());
    }
}