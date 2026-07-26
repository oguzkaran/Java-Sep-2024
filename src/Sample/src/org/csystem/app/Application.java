package org.csystem.app;

import org.csystem.util.console.Console;

class Application {
    public static void run(String[] args)
    {
        char c = Console.readChar("Input a character:", "Wrong input!...");

        Console.writeLine("c = %c", c);
    }
}