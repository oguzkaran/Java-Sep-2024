package org.csystem.app;

import org.csystem.util.console.Console;

import java.io.Closeable;
import java.io.IOException;

class App {
    public static void main(String[] args)
    {
        DemoApp.run();
    }
}

class DemoApp {
    public static void run()
    {
        String url = Console.readString("Input url:");
        String username = Console.readString("Input username:");
        String password = Console.readString("Input password:");

        try (DemoDbConnection connection = new DemoDbConnection(url, username, password)) {
            String sqlStr = Console.readString("Input SQL commmand:");

            connection.insert(sqlStr);
        }
        catch (IOException ex) {
            Console.writeLine("Problem occurred:%s", ex.getMessage());
        }
    }
}

class DemoDbConnection implements Closeable {
    private String m_url;
    private String m_username;
    private String m_password;

    //...

    private void checkInformation(String url, String username, String password) throws IOException
    {
        if (url == null || url.isBlank() || username == null || username.isBlank() || password == null)
            throw new IOException("Invalid connection parameters");
    }

    public DemoDbConnection(String url, String username, String password) throws IOException
    {
        checkInformation(url, username, password);
        m_url = url;
        m_username = username;
        m_password = password;
    }

    public void insert(String sqlStr) throws IOException
    {
        //...
        if (sqlStr == null || sqlStr.isBlank())
            throw new IOException("Sql string can be null or blank");

        Console.writeLine("'%s' sent to %s", sqlStr, m_url);
    }

    //...

    public void close() throws IOException
    {
        //...
        Console.writeLine("Connection of %s closed for %s", m_username, m_url);
    }
}