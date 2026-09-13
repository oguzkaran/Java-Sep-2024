package org.csystem.app.io.file.copy;

import org.csystem.util.console.Console;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthGreater;

public class CopyNotExistFilesApp {
    private static void copyFile(Path src, Path dest) throws IOException
    {
        try {
            Path exactDest = dest.resolve(src.getFileName());

            Files.copy(src, exactDest);
        }
        catch (FileAlreadyExistsException e) {
            Console.writeLine("File '%s' exits and will be kept", e.getFile());
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
