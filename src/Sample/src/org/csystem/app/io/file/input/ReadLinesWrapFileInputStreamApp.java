package org.csystem.app.io.file.input;

import org.csystem.util.console.Console;

import java.io.*;

import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;

public class ReadLinesWrapFileInputStreamApp {
    private static void readLines(FileInputStream fis) throws IOException
    {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(fis))) {
            String line;

            while ((line = br.readLine()) != null)
                Console.writeLine("%s", line);
        }
    }

    private static void readFile(String path)
    {
        try (FileInputStream fis = new FileInputStream(path)) {
            readLines(fis);
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
