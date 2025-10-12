package org.csystem.app.string.store;

import org.csystem.util.console.Console;

import java.util.ArrayList;

public class StoreStringsApp {
    public static void run()
    {
        ArrayList texts = new ArrayList(4);

        while (true) {
            String s = Console.readString("Input a text:");

            if ("exit".equals(s))
                break;

            texts.add(s);
        }

        for (Object o : texts)
            Console.writeLine((String)o);
    }

    public static void main(String[] args)
    {
        run();
    }
}