package org.csystem.app;

import org.csystem.util.console.Console;

class App {
    public static void main(String[] args)
    {
        int a = Console.readIntBinary("Input a hex number:");

        Console.writeLine("a = %d", a);
    }
}