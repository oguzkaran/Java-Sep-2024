package org.csystem.app.io.file.input;

import org.csystem.util.console.Console;
import org.csystem.util.converter.BitConvertUtil;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;

public class ReadFixedLengthStringsUTF8App {
    private static void readFile(String path)
    {
        try (InputStream is = Files.newInputStream(Path.of(path))) {
            byte [] dataFixedLength = new byte[Integer.BYTES];

            if (is.read(dataFixedLength) != dataFixedLength.length)
                throw new IOException("Invalid file format");

            int fixedLength = BitConvertUtil.toInt(dataFixedLength);

            if (fixedLength <= 0)
                throw new IOException("Fixed length must be positive. Invalid file format!...");

            int result;
            byte [] dataLen = new byte[fixedLength];

            while ((result = is.read(dataLen)) > 0) {
                if (result != fixedLength)
                    throw new IOException("Invalid file format!...");

                Console.write("%s ", BitConvertUtil.getNullTerminatedString(dataLen, StandardCharsets.UTF_8));
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
