package org.csystem.app;

import org.csystem.util.console.Console;
import org.csystem.util.string.StringUtil;

class App {
    public static void main(String[] args)
    {
        String s1 = Console.readString("Input first text:");
        String s2 = Console.readString("Input second text:");

        Console.writeLine("Count:%d", StringUtil.countString(s1, s2));
    }
}

