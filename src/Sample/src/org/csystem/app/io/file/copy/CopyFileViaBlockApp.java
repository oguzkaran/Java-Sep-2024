package org.csystem.app.io.file.copy;

import org.csystem.util.console.Console;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;

public class CopyFileViaBlockApp {
    private static void copyFile(String srcPath, String destPath, int blockSize)
    {
        try (FileInputStream fis = new FileInputStream(srcPath); FileOutputStream fos = new FileOutputStream(destPath)) {
            byte [] buf = new byte[blockSize];
            int result;

            while ((result = fis.read(buf)) > 0)
                fos.write(buf, 0, result);

            Console.writeLine("File copied successfully");
        }
        catch (IOException e) {
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
