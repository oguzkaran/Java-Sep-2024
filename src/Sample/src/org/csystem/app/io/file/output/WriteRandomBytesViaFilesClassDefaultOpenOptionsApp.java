package org.csystem.app.io.file.output;

import org.csystem.util.console.Console;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;

public class WriteRandomBytesViaFilesClassDefaultOpenOptionsApp {
    private static void writeFile(String path, int count)
    {
        try (OutputStream fos = Files.newOutputStream(Paths.get(path))) {
            Random r = new Random();

            for (int i = 0; i < count; ++i) {
                byte v = (byte)r.nextInt(-128, 128);

                Console.write("%d ", v);
                fos.write(v);
            }

            Console.writeLine();
        }
        catch (FileNotFoundException ignore) {
            Console.writeErrLine("Error occurred while creating file:%s", path);
        }
        catch (IOException e) {
            Console.writeErrLine("IO error occurred:%s", e.getMessage());
        }
    }

    private static void run(String[] args)
    {
        checkLengthEquals(2, args.length, "Wrong number of arguments");

        try {
            int count = Integer.parseInt(args[1]);

            if (count < 1)
                throw new NumberFormatException();

            writeFile(args[0], count);
        }
        catch (NumberFormatException ignore) {
            Console.writeErrLine("Count must be a positive integer");
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
