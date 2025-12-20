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
        String sqlStr = Console.readString("Input SQL command:");

        try (Statement statement = new Statement(sqlStr); DemoDbConnection connection = new DemoDbConnection(url, username, password, statement)) {
            connection.insert();
        }
        catch (IOException ex) {
            Console.writeLine("Problem occurred:%s", ex.getMessage());
        }
    }
}

class Statement implements Closeable {
    private final String m_sqlStr;

    public Statement(String sqlStr) throws IOException
    {
        Console.writeLine("Preparing SQL statement:");
        if (sqlStr == null || sqlStr.isBlank())
            throw new IOException("SQL statement can not be null or blank");

        m_sqlStr = sqlStr;
    }

    public String getSqlStr()
    {
        return m_sqlStr;
    }

    //...

    public void close() throws IOException
    {
        //...
        Console.writeLine("Closing SQL statement:");
    }
}

class DemoDbConnection implements Closeable {
    private String m_url;
    private String m_username;
    private String m_password;
    private Statement m_statement;

    //...

    private void checkInformation(String url, String username, String password) throws IOException
    {
        if (url == null || url.isBlank() || username == null || username.isBlank() || password == null)
            throw new IOException("Invalid connection parameters");
    }

    public DemoDbConnection(String url, String username, String password, Statement statement) throws IOException
    {
        checkInformation(url, username, password);
        m_url = url;
        m_username = username;
        m_password = password;
        m_statement = statement;
    }

    public void insert() throws IOException
    {
        //...
        Console.writeLine("'%s' sent to %s", m_statement.getSqlStr(), m_url);
    }

    //...

    public void close() throws IOException
    {
        //...
        Console.writeLine("Connection of %s closed for %s", m_username, m_url);
    }
}