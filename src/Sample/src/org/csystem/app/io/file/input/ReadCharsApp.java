package org.csystem.app.io.file.input;

import org.csystem.util.console.Console;

import java.io.*;

import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;

public class ReadCharsApp {
    private static void readFile(String path)
    {
        try (FileInputStream fis = new FileInputStream(path);
             DataInputStream dis = new DataInputStream(fis)) {

            while (true) {
                char c = dis.readChar();

                Console.write("%c", c);
            }
        }
        catch (EOFException ignore) {
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
