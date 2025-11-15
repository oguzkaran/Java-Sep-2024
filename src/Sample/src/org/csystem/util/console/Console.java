package org.csystem.util.console;


import java.util.Scanner;

/**
 * Utility class for console operations
 * Last Update: 15th November 2025
 * @author Java-Sep-2024 Group
 */
public final class Console {
    private static final int RADIX_DECIMAL;
    private static final int RADIX_HEXADECIMAL;
    private static final int RADIX_BINARY;
    private static final Scanner KB;

    static {
        RADIX_DECIMAL = 10;
        RADIX_HEXADECIMAL = 16;
        RADIX_BINARY = 2;
        KB = new Scanner(System.in);
    }

    private Console()
    {}

    public static int readInt()
    {
        return readInt("");
    }

    public static int readInt(String prompt)
    {
        return readInt(prompt, "");
    }

    public static int readInt(String prompt, String errorPrompt)
    {
        return readInt(prompt, RADIX_DECIMAL, errorPrompt);
    }

    public static int readInt(int radix)
    {
        return readInt("", radix, "");
    }

    public static int readInt(String prompt, int radix)
    {
        return readInt(prompt, radix, "");
    }

    public static int readInt(String prompt, int radix, String errorPrompt)
    {
        while (true) {
            try {
                System.out.print(prompt);

                return Integer.parseInt(KB.nextLine(), radix);
            }
            catch (NumberFormatException ignore) {
                System.out.print(errorPrompt);
            }
        }
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
        return readDouble(prompt, "");
    }

    public static double readDouble(String prompt, String errorPrompt)
    {
        while (true) {
            try {
                System.out.print(prompt);

                return Double.parseDouble(KB.nextLine());
            }
            catch (NumberFormatException ignore) {
                System.out.print(errorPrompt);
            }
        }
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
        return readLong(prompt, radix, "");
    }

    public static long readLong(String prompt, int radix, String errorPrompt)
    {
        while (true) {
            try {
                System.out.print(prompt);

                return Long.parseLong(KB.nextLine());
            }
            catch (NumberFormatException ignore) {
                System.out.print(errorPrompt);
            }
        }
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
