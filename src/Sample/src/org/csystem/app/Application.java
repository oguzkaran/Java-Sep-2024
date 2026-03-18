package org.csystem.app;

import org.csystem.util.console.Console;

class Application {
    public static void run(String[] args)
    {
        Console.writeLine("File separator:%s", System.getProperty("file.separator"));
        Console.writeLine("System:%s",  System.getProperty("file.separator").charAt(0) == '/' ? "Unix-Linux" : "Windows");
        Console.writeLine("Java Version:%s", System.getProperty("java.version"));
        Console.writeLine("OS architecture:%s", System.getProperty("os.arch"));
        Console.writeLine("OS version:%s", System.getProperty("os.version"));
        Console.writeLine("OS name:%s", System.getProperty("os.name"));
        Console.writeLine("Java Vendor:%s", System.getProperty("java.vendor"));
        Console.writeLine("User name:%s", System.getProperty("user.name"));
    }
}
