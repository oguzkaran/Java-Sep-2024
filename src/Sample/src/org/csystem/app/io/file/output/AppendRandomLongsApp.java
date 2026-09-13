package org.csystem.app.io.file.output;

import org.csystem.util.console.Console;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Random;

import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;

public class AppendRandomLongsApp {
    private static void writeFile(String path, int count, long origin, long bound)
    {
        try (FileOutputStream fos = new FileOutputStream(path, true)) {
            Random r = new Random();

            for (int i = 0; i < count; ++i) {
                long v = r.nextLong(origin, bound);

                Console.write("%d ", v);
                byte [] buf = ByteBuffer.allocate(Long.BYTES)
                        .putLong(v)
                        .array();

                fos.write(buf);
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
        checkLengthEquals(4, args.length, "Wrong number of arguments");

        try {
            int count = Integer.parseInt(args[1]);
            long origin = Long.parseLong(args[2]);
            long bound = Long.parseLong(args[3]);

            if (count < 1)
                throw new NumberFormatException();

            writeFile(args[0], count, origin, bound);
        }
        catch (NumberFormatException ignore) {
            Console.writeErrLine("Invalid value(s)");
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
