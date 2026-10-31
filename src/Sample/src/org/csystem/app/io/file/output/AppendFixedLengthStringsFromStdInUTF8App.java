package org.csystem.app.io.file.output;

import org.csystem.util.console.Console;
import org.csystem.util.converter.BitConvertUtil;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardOpenOption.*;
import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;

public class AppendFixedLengthStringsFromStdInUTF8App {
    private static void writeFile(OutputStream os, int fixedLength) throws IOException
    {
        while (true) {
            String s = Console.readString("Input text:");

            if ("exit".equals(s))
                break;

            if (BitConvertUtil.getBytes(s, StandardCharsets.UTF_8).length < fixedLength) {
                byte [] buf = BitConvertUtil.getNullTerminatedBytes(s, fixedLength, StandardCharsets.UTF_8);

                os.write(buf);
            }
            else
                Console.writeLine("Length must be less than %d", fixedLength);
        }
    }

    private static void writeFile(Path path, int fixedLength) throws IOException
    {
        try (OutputStream os = Files.newOutputStream(path, APPEND, WRITE, CREATE)) {
            if (Files.size(path) == 0)
                os.write(BitConvertUtil.getBytes(fixedLength));

            writeFile(os, fixedLength);
        }
        catch (FileNotFoundException ignore) {
            Console.writeErrLine("Error occurred while creating file:%s", path);
        }
        catch (IOException e) {
            Console.writeErrLine("IO error occurred:%s", e.getMessage());
        }
    }

    private static int readFixedLengthFromFile(Path path) throws IOException
    {
        try (InputStream is = Files.newInputStream(path)) {
            byte [] buf =  new byte[Integer.BYTES];

            if (is.read(buf) != Integer.BYTES)
                throw new IOException("Error occurred while reading fixed length from file. Invalid file format!...");

            int fixedLength = BitConvertUtil.toInt(buf);

            if (fixedLength <= 0)
                throw new IOException("Fixed length must be positive. Invalid file format!...");

            return fixedLength;
        }
    }

    private static int readFixedLengthFromStdin(int maxFixedLength)
    {
        while (true) {
            int fixedLength = Console.readInt("Input fixed length value in [1, %d]:".formatted(maxFixedLength), "Invalid int value:!...");

            if (0 < fixedLength && fixedLength <= maxFixedLength)
                return fixedLength;

            Console.writeLine("Fixed length must be in [1, %d]",  maxFixedLength);
        }
    }

    private static int getFixedLengthValue(Path path, int maxFixedLength) throws IOException
    {
        return Files.exists(path) ? readFixedLengthFromFile(path) : readFixedLengthFromStdin(maxFixedLength);
    }

    private static void run(String[] args)
    {
        checkLengthEquals(2, args.length, "Wrong number of arguments");

        try {
            int maxFixedLength = Integer.parseInt(args[1]);

            if (maxFixedLength <= 0)
                throw new NumberFormatException();

            Path path = Path.of(args[0]);

            int fixedLengthValue = getFixedLengthValue(path, maxFixedLength);

            writeFile(path, fixedLengthValue);
        }
        catch (NumberFormatException ignore) {
            Console.writeErrLine("Invalid maximum fixed length value:");
        }
        catch (IOException e) {
            Console.writeErrLine("IO Error occurred:%s", e.getMessage());
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
