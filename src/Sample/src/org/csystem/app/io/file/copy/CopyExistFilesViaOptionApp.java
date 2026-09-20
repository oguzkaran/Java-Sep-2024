package org.csystem.app.io.file.copy;

import org.csystem.util.console.Console;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.*;

import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthGreater;

public class CopyExistFilesViaOptionApp {
    private static void printMenu(Path src)
    {
        Console.writeLine("%s exists. Please choose one of them:", src);
        Console.writeLine("Overwrite (w/W)");
        Console.writeLine("Append (a/A)");
        Console.writeLine("Skip (s/S)");
        Console.write("Option:");
    }

    private static char getOption(Path src)
    {
        while (true) {
            printMenu(src);
            char option = Console.readChar("", "Invalid Option format!!!. Please choose again:");

            switch (option) {
                case 'w', 'W', 'a', 'A', 's', 'S' -> {return option;}
            }
        }
    }

    private static void overwriteCallback(Path exactDest, Path src) throws IOException
    {
        Console.writeLine("File %s will be overwritten", src);
        Files.copy(src, exactDest, StandardCopyOption.REPLACE_EXISTING);
    }

    private static void appendCallback(Path exactDest, Path src) throws IOException
    {
        Console.writeLine("File '%s' exists and new data will append", src);
        try (OutputStream fos = Files.newOutputStream(exactDest, StandardOpenOption.APPEND, StandardOpenOption.CREATE)) {
            Files.copy(src, fos);
        }
    }

    private static void skipCallback(Path exactDest, Path src) throws IOException
    {
        Console.writeLine("File '%s' exits and will be kept", src);
    }

    private static void copyFile(Path src, Path dest) throws IOException
    {
        try {
            Path exactDest = dest.resolve(src.getFileName());

            if (Files.exists(exactDest)) {
                char option = getOption(src);

                switch (option) {
                    case 'w', 'W' -> overwriteCallback(exactDest, src);
                    case 'a', 'A' -> appendCallback(exactDest, src);
                    case 's', 'S' -> skipCallback(exactDest, src);
                }
            }
            else
                Files.copy(src, exactDest);
        }
        catch (NoSuchFileException e) {
            Console.writeErrLine("File '%s' does not exist", src);
        }
    }

    private static void run(String[] args)
    {
        checkLengthGreater(1, args.length, "Wrong number of arguments");

        try {
            Path dest = Path.of(args[0]);
            Files.createDirectories(dest);

            for (int i = 1; i < args.length; ++i)
                copyFile(Path.of(args[i]), dest);
        }
        catch (IOException e) {
            Console.writeErrLine("IO Error occurred:%s", e.getMessage());
        }
        catch (Exception e) {
            Console.writeErrLine("Error occurred:%s", e.getMessage());
        }
    }

    public static void main(String[] args)
    {
        run(args);
    }
}
