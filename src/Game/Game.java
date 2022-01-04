package Game;

import Character.Specialisations.Dwarf;
import Character.Specialisations.Giant;
import Character.Specialisations.Human;
import Inventory.Weapons.BasicShinGuard;
import Inventory.Weapons.BasicSyntheticGloves;
import Inventory.Weapons.BlackPandaGloves;
import Inventory.Weapons.Weapons;
import Character.Character;
import Log.Logger;
import Display.Display;
import Shop.Shop;


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
        Shop shop = Shop.getShopInstance();

        Display game = new Display();
        Character player = game.createCharacter();
        game.setCharacter(player);
        game.startGame();

        while (true) {
            game.getMenu(player,game.Menu(),shop);
        }


        /*Weapons Glock = new BasicSyntheticGloves();
        Enzo.setWeapons(Glock);
        Dwarf Baptiste = new Dwarf("Baptiste");
        Weapons Panda = new BasicSyntheticGloves();
        Baptiste.setWeapons(Panda);

        Giant louis = new Giant("Louis");
        Weapons plug = new BasicSyntheticGloves();
        louis.setWeapons(plug);

        Enzo.setX(1);
        Enzo.setY(1);

        Baptiste.setX(2);
        Baptiste.setY(1);

        louis.setX(3);
        louis.setY(3);

        Enzo.attack(Baptiste);
        Baptiste.attack(Enzo);
        Enzo.attack(louis);*/
    }
}