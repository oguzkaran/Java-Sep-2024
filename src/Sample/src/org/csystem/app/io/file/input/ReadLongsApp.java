package org.csystem.app.io.file.input;

import org.csystem.util.console.Console;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;

import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;

public class ReadLongsApp {
    private static void readFile(String path)
    {
        try (FileInputStream fis = new FileInputStream(path)) {
            int result;
            byte [] data = new byte[Long.BYTES];

            while ((result = fis.read(data)) > 0) {
                long v = ByteBuffer.wrap(data, 0, result).getLong();

                Console.write("%d ", v);
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
        checkLengthEquals(1, args.length, "Wrong number of arguments");

        try {
            readFile(args[0]);
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
