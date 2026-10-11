package org.csystem.app.io.file.output;

import org.csystem.util.console.Console;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;

public class AppendStringsFromStdInApp {
    private static void writeFile(FileOutputStream fos) throws IOException
    {
        while (true) {
            String s = Console.readString("Input text:");

            if ("exit".equals(s))
                break;

            byte[] data = s.getBytes();
            byte[] dataLen = ByteBuffer.allocate(2).putShort((short)data.length).array();

            fos.write(dataLen);
            fos.write(data);
        }
    }

    private static void writeFile(String path)
    {
        try (FileOutputStream fos = new FileOutputStream(path, true)) {
            writeFile(fos);
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
