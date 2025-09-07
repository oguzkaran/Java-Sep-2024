package org.csystem.util.console.commanline;

/**
 * Utility class for command line arguments operations
 * Last Update: 7th September 2025
 * @author Java-Sep-2024 Group
 */
public final class CommandLineArgsUtil {
    private CommandLineArgsUtil()
    {
    }

    public static void checkLengthEquals(int length, int argsLength, String errorMessage, int exitCode)
    {
        if (argsLength != length) {
            System.err.println(errorMessage);
            System.exit(exitCode);
        }
    }

    public static void checkLengthEquals(int length, int argsLength, String errorMessage)
    {
        checkLengthEquals(length, argsLength, errorMessage, 1);
    }

    public static void checkLengthGreater(int length, int argsLength, String errorMessage)
    {
        checkLengthGreater(length, argsLength, errorMessage, 1);
    }

    public static void checkLengthGreater(int length, int argsLength, String errorMessage, int exitCode)
    {
        if (argsLength <= length) {
            System.err.println(errorMessage);
            System.exit(exitCode);
        }
    }

    public static void checkLengthLess(int length, int argsLength, String errorMessage)
    {
        checkLengthLess(length, argsLength, errorMessage, 1);
    }

    public static void checkLengthLess(int length, int argsLength, String errorMessage, int exitCode)
    {
        if (argsLength >= length) {
            System.err.println(errorMessage);
            System.exit(exitCode);
        }
    }

    //...
}
