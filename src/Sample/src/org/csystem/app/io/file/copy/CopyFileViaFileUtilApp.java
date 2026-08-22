package org.csystem.app.io.file.copy;

import org.csystem.util.console.Console;
import org.csystem.util.io.file.FileUtil;

import java.io.UncheckedIOException;

import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;

public class CopyFileViaFileUtilApp {
    private static void copyFile(String srcPath, String destPath, int blockSize)
    {
        try {
            FileUtil.copy(srcPath, destPath, blockSize);
            Console.writeLine("File copied successfully");
        }
        catch (UncheckedIOException e) {
            Console.writeErrLine("IO Error occurred:%s", e.getMessage());
        }
    }

    private static void run(String[] args)
    {
        checkLengthEquals(3, args.length, "Wrong number of arguments");

        try {
            int blockSize = Integer.parseInt(args[2]);

            if (blockSize <= 0)
                throw new NumberFormatException("Wrong number of arguments");

            copyFile(args[0], args[1], blockSize);
        }
        catch (NumberFormatException ignore) {
            Console.writeErrLine("Invalid block size");
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
