package org.csystem.util.console;


import java.util.Scanner;

/**
 * Utility class for console operations
 * Last Update: 20th September 2025
 * @author Java-Sep-2024 Group
 */
public final class Console {
    private static final int RADIX_DECIMAL = 10;
    private static final int RADIX_HEXADECIMAL = 16;
    private static final int RADIX_BINARY = 2;
    private static final Scanner KB = new Scanner(System.in);

    private Console()
    {}

    public static int readInt()
    {
        return readInt("");
    }

    public static int readInt(String prompt)
    {
        return readInt(prompt, RADIX_DECIMAL);
    }

    public static int readInt(int radix)
    {
        return readInt("", radix);
    }

    public static int readInt(String prompt, int radix)
    {
        System.out.print(prompt);

        return Integer.parseInt(KB.nextLine(), radix);
    }

    public static int readIntHexadecimal()
    {
        return readIntHexadecimal("");
    }

    public static int readIntHexadecimal(String prompt)
    {
        return readInt(prompt, RADIX_HEXADECIMAL);
    }

    public static int readIntBinary()
    {
        return readIntBinary("");
    }

    public static int readIntBinary(String prompt)
    {
        return readInt(prompt, RADIX_BINARY);
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
        return readLong(prompt, RADIX_DECIMAL);
    }

    public static long readLong(int radix)
    {
        return readLong("", radix);
    }

    public static long readLong(String prompt, int radix)
    {
        System.out.print(prompt);

        return Long.parseLong(KB.nextLine());
    }

    public static long readLongHexadecimal()
    {
        return readLongHexadecimal("");
    }

    public static long readLongHexadecimal(String prompt)
    {
        return readLong(prompt, RADIX_HEXADECIMAL);
    }

    public static long readLongBinary()
    {
        return readLongBinary("");
    }

    public static long readLongBinary(String prompt)
    {
        return readLong(prompt, RADIX_BINARY);
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
