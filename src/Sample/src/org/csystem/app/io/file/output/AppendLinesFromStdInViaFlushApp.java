package org.csystem.app.io.file.output;

import org.csystem.util.console.Console;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;
import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;

public class AppendLinesFromStdInViaFlushApp {
    private static void writeFile(BufferedWriter bw) throws IOException
    {
        while (true) {
            String s = Console.readString("Input text:");

            if ("exit".equals(s))
                break;

            bw.write(s);
            bw.newLine();
            bw.flush();
        }
    }

    private static void writeFile(String path)
    {
        try (BufferedWriter bw = Files.newBufferedWriter(Path.of(path), APPEND, CREATE)) {
            writeFile(bw);
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
        checkLengthEquals(1, args.length, "Wrong number of arguments");

        try {
            writeFile(args[0]);
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
