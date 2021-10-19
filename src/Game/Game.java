package Game;
import  Log.Logger;
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

}
