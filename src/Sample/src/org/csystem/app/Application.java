package org.csystem.app;

import org.csystem.util.console.Console;

import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;

class Application {
    public static void run(String[] args)
    {
        checkLengthEquals(1, args.length, "Wrong number of arguments");

        Path path = Path.of(args[0]);

        try {
            boolean result = Files.deleteIfExists(path);

            if (result) {
                if (Files.isDirectory(path))
                    Console.writeLine("Directory '%s' deleted", args[0]);
                else
                    Console.writeLine("File '%s' deleted", args[0]);
            }
            else
                Console.writeLine("%s not found", args[0]);
        }
        catch (DirectoryNotEmptyException e) {
            Console.writeErrLine("Non empty directory can not be deleted:%s", e.getMessage());
        }
        catch (IOException e) {
            Console.writeErrLine("IO error occurred:%s", e.getMessage());
        }
        catch (Exception e) {
            Console.writeErrLine("Error occurred:%s", e.getMessage());
        }
    }
}