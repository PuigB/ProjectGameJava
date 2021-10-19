package Log;
import java.time.Instant;
public class Logger
{
    /**
     * enum
     */
    public enum LOG_LEVEL
    {
       LOG,
       DEBUG,
       ERROR
    }

    /**
     * methods
     */
    public static void addLog(String log,String name,LOG_LEVEL log_level)
    {
        String icon = " [!] ";
        switch(log_level)
        {
            case LOG :
                icon = " [+] ";
            break;
            case DEBUG :
                icon = " [&] ";
            break;

            case ERROR :
                icon = " [-] ";
            break;

            default:
            break;

        }
        System.out.print( Instant.now().toString() + icon + name + " - " + log + "\n" );
    }
}
