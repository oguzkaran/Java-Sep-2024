package org.csystem.app;

import org.csystem.util.console.Console;

class Application {
    public static void run(String[] args)
    {
        Console.writeLine(System.lineSeparator().equals("\r\n") ? "Windows" : "Not Windows (Unix/Linux/Mac OS X)");
    }
}