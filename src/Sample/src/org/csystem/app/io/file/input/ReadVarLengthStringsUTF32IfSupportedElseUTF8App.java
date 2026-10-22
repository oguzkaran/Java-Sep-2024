package org.csystem.app.io.file.input;

import org.csystem.util.console.Console;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;

public class ReadVarLengthStringsUTF32IfSupportedElseUTF8App {
    private static void readFile(String path)
    {
        try (FileInputStream fis = new FileInputStream(path)) {
            int result;
            byte [] dataLen = new byte[Short.BYTES];

            while ((result = fis.read(dataLen)) > 0) {
                if (result != Short.BYTES)
                    throw new IOException("Bad file format");

                short len = ByteBuffer.wrap(dataLen).getShort();

                byte [] data = new byte[len];

                if (fis.read(data, 0, len) != len)
                    throw new IOException("Bad file format");

                Charset charset;

                if (!Charset.isSupported("UTF-32")) {
                    Console.writeLine("UTF-32 charset encoding not supported. UTF-8 will be used");
                    charset = StandardCharsets.UTF_8;
                }
                else
                    charset = Charset.forName("UTF-32");

                String text = new String(data, charset);

                Console.write("%s ", text);
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
