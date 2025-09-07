package org.csystem.util.console;


import java.util.Scanner;

/**
 * Utility class for console operations
 * Last Update: 27th September 2025
 * @author Java-Sep-2024 Group
 */
public final class Console {
    private static final Scanner KB = new Scanner(System.in);
    private Console()
    {}

    public static int readInt()
    {
        return readInt("");
    }

    public static int readInt(String prompt)
    {
        System.out.print(prompt);

        return Integer.parseInt(KB.nextLine());
    }

    public static double readDouble()
    {
        return readDouble("");
    }

    public static double readDouble(String prompt)
    {
        System.out.print(prompt);

        return Double.parseDouble(KB.nextLine());
    }

    public static long readLong()
    {
        return readLong("");
    }

    public static long readLong(String prompt)
    {
        System.out.print(prompt);

        return Long.parseLong(KB.nextLine());
    }

    public static String readString()
    {
        return readString("");
    }

    public static String readString(String prompt)
    {
        System.out.print(prompt);
        return KB.nextLine();
    }

    //...

    public static void write(Object o)
    {
        System.out.print(o);
    }

    public static void write(String format, Object...args)
    {
        System.out.printf(format, args);
    }

    public static void writeLine()
    {
        System.out.println();
    }

    public static void writeLine(Object o)
    {
        System.out.println(o);
    }

    public static void writeLine(String format, Object...args)
    {
        write(format + "%n", args);
    }
}
