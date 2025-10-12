package org.csystem.app;

import org.csystem.util.console.Console;

class App {
    public static void main(String[] args)
    {
        UtilModTest.run();
    }
}

class UtilModTest {
    public static void run()
    {
        Console.writeLine(Util.mod(10, 3) == 1);
        Console.writeLine(Util.mod(-10, 3) == 2);
        Console.writeLine(Util.mod(11, 7) == 4);
        Console.writeLine(Util.mod(-11, 7) == 3);
    }
}

class Util {
    public static int mod(int a, int b)
    {
        int result = a % b;

        return result >= 0 ? result: result + b;
    }
}