package org.csystem.app.io.file.output;

import org.csystem.util.console.Console;
import org.csystem.util.string.StringUtil;

import java.io.*;
import java.util.Random;

import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;

public class AppendRandomLinesWrapFileOutputStreamApp {
    private static void writeFile(FileOutputStream fos, long count) throws IOException
    {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos))) {
            Random random = new Random();

            while (count-- > 0)
                bw.write("%s\r\n".formatted(StringUtil.randomTextTR(random, random.nextInt(1, 65))));
        }
    }

    private static void writeFile(String path, long count)
    {
        try (FileOutputStream fos = new FileOutputStream(path, true)) {
            writeFile(fos, count);
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
