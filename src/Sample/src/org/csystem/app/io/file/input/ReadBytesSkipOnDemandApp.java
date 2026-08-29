package org.csystem.app.io.file.input;

import org.csystem.util.console.Console;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;

public class ReadBytesSkipOnDemandApp {
    private static void readFile(String path, long n)
    {
        try (FileInputStream fis = new FileInputStream(path)) {
            long len = Files.size(Path.of(path));

            if (len < n)
                Console.writeLine("EOF reached while skipping %d bytes. Number of skipped bytes:%d", n, len);

            fis.skip(n);

            int v;

            while ((v = fis.read()) != -1) {
                byte b = (byte)v;

                Console.write("%d ", b);
            }

            Console.writeLine();
        }
        catch (FileNotFoundException ignore) {
            Console.writeErrLine("Error occurred while opening file:%s", path);
        }
        catch (IOException e) {
            Console.writeErrLine("IO error occurred:%s", e.getMessage());
        }
    }

    private static void run(String[] args)
    {
        checkLengthEquals(2, args.length, "Wrong number of arguments");

        try {
            long n = Long.parseLong(args[1]);

            if (n <= 0)
                throw new NumberFormatException();

            readFile(args[0], n);
        }
        catch (NumberFormatException ignore) {
            Console.writeErrLine("Invalid number of bytes value to skip");
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
