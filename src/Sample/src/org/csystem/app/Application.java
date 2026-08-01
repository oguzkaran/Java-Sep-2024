package org.csystem.app;

import org.csystem.util.console.Console;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;

class Application {
    public static void run(String[] args)
    {
        checkLengthEquals(1, args.length, "Wrong number of arguments");

        try {
            Path path = Path.of(args[0]);

            Files.createDirectory(path);
            Console.writeLine("Directory '%s' created", args[0]);
        }
        catch (FileAlreadyExistsException e) {
            Console.writeErrLine("'%s' exists", e.getFile());
        }
        catch (IOException e) {
            Console.writeErrLine("IO error occurred:%s", e.getMessage());
        }
        catch (Exception e) {
            Console.writeErrLine("Error occurred:%s", e.getMessage());
        }
    }
}