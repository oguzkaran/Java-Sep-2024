package org.csystem.app;

import org.csystem.util.console.Console;

class App {
    public static void main(String[] args)
    {
        int a = Console.readInt("Input first value:", "Invalid value!...");
        int b = Console.readInt("Input second value:", "Invalid value!...");

        Console.writeLine("%d + %d = %d", a, b, a + b);
    }
}