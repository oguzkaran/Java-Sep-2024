package org.csystem.app.io.file.output;

import org.csystem.util.console.Console;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;

public class AppendRandomByteArrayApp {
    private static void writeFile(String path, int count)
    {
        try (FileOutputStream fos = new FileOutputStream(path, true)) {
            Random r = new Random();
            byte [] buf = new byte[count];

            r.nextBytes(buf);

            Console.write("Generated data:");
            for (byte d : buf)
                Console.write("%d ", d);

            fos.write(buf);
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
