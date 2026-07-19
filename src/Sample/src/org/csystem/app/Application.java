package org.csystem.app;

import org.csystem.util.console.Console;

import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;

class Application {
    public static void run(String[] args)
    {
        checkLengthEquals(2, args.length, "Wrong number of arguments");

        try {
            Path srcPath = Path.of(args[0]);
            Path destPath = Path.of(args[1]);

            Files.move(srcPath, destPath, REPLACE_EXISTING);
            Console.writeLine("File successfully copied");
        }
        catch (DirectoryNotEmptyException ignore) {
            Console.writeErrLine("Non empty directory:%s", args[1]);
        }
        catch (IOException e) {
            Console.writeErrLine("IO error occurred:%s", e.getMessage());
        }
        catch (Exception e) {
            Console.writeErrLine("Error occurred:%s", e.getMessage());
        }
    }
}