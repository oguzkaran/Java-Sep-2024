package org.csystem.app.io.file.output;

import org.csystem.util.console.Console;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;

public class AppendLinesFromStdInViaBufSizeApp {
    private static void writeFile(BufferedWriter bw) throws IOException
    {
        while (true) {
            String s = Console.readString("Input text:");

            if ("exit".equals(s))
                break;

            bw.write(s);
            bw.newLine();
        }
    }

    private static void writeFile(String path, int bufSize)
    {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, StandardCharsets.UTF_8, true), bufSize)) {
            writeFile(bw);
        } catch (FileNotFoundException ignore) {
            Console.writeErrLine("Error occurred while creating file:%s", path);
        } catch (IOException e) {
            Console.writeErrLine("IO error occurred:%s", e.getMessage());
        }
    }

    private static void run(String[] args)
    {
        checkLengthEquals(2, args.length, "Wrong number of arguments");

        try {
            int bufSize = Integer.parseInt(args[1]);

            writeFile(args[0], bufSize);
        }
        catch (NumberFormatException ignore) {
            Console.writeErrLine("Invalid buffer size value!...");
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
