package org.csystem.app.io.file.input;

import org.csystem.util.array.ArrayUtil;
import org.csystem.util.console.Console;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;

public class ReadBytesViaChunkViaFilesClassDefaultOpenOptionsApp {
    private static void readFile(String path, int chunkSize)
    {
        try (InputStream fis = Files.newInputStream(Paths.get(path))) {
            byte [] buf = new byte[chunkSize];
            int result;

            while ((result = fis.read(buf)) != -1)
                ArrayUtil.print(buf, result, ", ", " ");

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
            int chunkSize = Integer.parseInt(args[1]);

            if (chunkSize <= 0)
                throw new NumberFormatException();

            readFile(args[0], chunkSize);
        }
        catch (NumberFormatException ignore) {
            Console.writeErrLine("Invalid chunk size");
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
