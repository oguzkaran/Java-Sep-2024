package org.csystem.app.io.file.output;

import org.csystem.util.console.Console;
import org.csystem.util.string.StringUtil;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;
import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;

public class AppendRandomLinesApp {
    private static void writeFile(BufferedWriter bw, long count) throws IOException
    {
        Random random = new Random();

        while (count-- > 0)
            bw.write("%s\r\n".formatted(StringUtil.randomTextTR(random, random.nextInt(1, 65))));
    }

    private static void writeFile(String path, long count)
    {
        try (BufferedWriter bw = Files.newBufferedWriter(Path.of(path), APPEND,  CREATE)) {
            writeFile(bw, count);
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
            long count = Long.parseLong(args[1]);

            if (count < 1)
                throw new NumberFormatException();

            writeFile(args[0], count);
        }
        catch (NumberFormatException ignore) {
            Console.writeErrLine("Invalid count value!...");
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
