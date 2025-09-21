package org.csystem.app;

import org.csystem.util.console.Console;

class App {
    public static void main(String[] args)
    {
       Long lVal = 3_000_000_000L;
       long val = 3_000_000_000L;
       int a, b;

       a = lVal.intValue();
       b = (int)val;

       Console.writeLine("%016X", 3_000_000_000L);
       Console.writeLine("a = %d, b = %d", a, b);
       Console.writeLine("a = %08X, b = %08X", a, b);
    }
}