package org.csystem.util.thread;


/**
 * Utility class for thread operations
 * Last Update: 27th July 2025
 * @author Java-Sep-2024 Group
 */
public class ThreadUtil {
    private ThreadUtil()
    {
    }

    public static void sleep(long ms)
    {
        try {
            Thread.sleep(ms);
        }
        catch (InterruptedException ignore) {

        }
    }
}
