package Game;
import Log.Logger;
public class GameObject {
    /***
     * Attribute
     */
    protected String m_Name;

    /***
     * Getter
     */
    public String getName()
    {
        return m_Name;
    }

    /***
     * Setter
     */
    public void setName(String name)
    {
        m_Name=name;
        Logger.addLog("test set name",m_Name, Logger.LOG_LEVEL.LOG);
    }


}
