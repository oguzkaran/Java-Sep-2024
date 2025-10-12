package org.csystem.app.string.store;

import org.csystem.util.console.Console;

public class ConcatWithHyphenApp {
    public static void run()
    {
        StringBuilder sb = new StringBuilder();

        Console.writeLine("Length:%d", sb.length());
        Console.writeLine("Capacity:%d", sb.capacity());
        Console.writeLine("----------------------------------");

        while (true) {
            String s = Console.readString("Input a text:");

            if ("exit".equals(s))
                break;

            sb.append(s).append('-');

            Console.writeLine("Length:%d", sb.length());
            Console.writeLine("Capacity:%d", sb.capacity());
            Console.writeLine("----------------------------------");
        }
        sb.deleteCharAt(sb.length() - 1);
        Console.writeLine("Length:%d", sb.length());
        Console.writeLine("Capacity:%d", sb.capacity());
    }

    public static void main(String[] args)
    {
        run();
    }
}
