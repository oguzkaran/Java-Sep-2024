package org.csystem.app.io.file.convert;

import org.csystem.util.console.Console;
import org.csystem.util.converter.BitConvertUtil;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardOpenOption.*;
import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;

public class ConvertUTF16ToUTF8App {
    private static char getOption(Path targetPath)
    {
        char option;

        do
            option = Console.readChar("%s exists. Do you want to overwrite?".formatted(targetPath.getFileName()));
        while(option != 'y' && option != 'Y' && option != 'n' && option != 'N');

        return option;
    }

    private static String readUtf16Text(InputStream is, byte[] dataLen) throws IOException
    {
        int result;

        result = is.read(dataLen);

        if (result == -1)
            return null;

        if (result != dataLen.length)
            throw new IOException("File corrupted!...");

        int len = BitConvertUtil.toShort(dataLen);

        if (len <= 0)
            throw new IOException("File corrupted!!...");

        byte [] dataStr = new byte[len];

        if (is.read(dataStr) != dataStr.length)
            throw new IOException("File corrupted!...");

        return BitConvertUtil.getString(dataStr, StandardCharsets.UTF_16);
    }

    private static void writeUtf8Text(OutputStream os, String text) throws IOException
    {
        byte[] data = BitConvertUtil.getBytes(text);
        byte[] dataLen = BitConvertUtil.getBytes((short)text.length());

        os.write(dataLen);
        os.write(data);
    }

    private static void convert(Path srcPath, Path targetPath) throws IOException
    {
        try (InputStream is = Files.newInputStream(srcPath);
             OutputStream os = Files.newOutputStream(targetPath, CREATE, WRITE, TRUNCATE_EXISTING)) {
            byte [] dataLen = new byte [Short.BYTES];

            while (true) {
                String text = readUtf16Text(is, dataLen);

                if (text == null)
                    break;

                writeUtf8Text(os, text);
            }
            Console.writeLine("Successfully converted from UTF-16 text to UTF-8");
        } catch (IOException e) {
            Files.deleteIfExists(targetPath);
            Console.writeLine("IO Error occurred:%s", e.getMessage());
        }
    }

    private static void convertToUtf8(Path srcPath, Path targetPath) throws IOException
    {
        if (Files.notExists(srcPath)) {
            Console.writeErrLine("Source file does not exist:%s", srcPath.toString());
            return;
        }

        if (Files.exists(targetPath)) {
            char option = getOption(targetPath);

            if (option == 'n' || option == 'N') {
                Console.writeLine("File already exists. Rejected to overwrite!...");
                return;
            }
        }

        convert(srcPath, targetPath);
    }

    private static void run(String[] args)
    {
        checkLengthEquals(2, args.length, "Wrong number of arguments");

        try {
            convertToUtf8(Path.of(args[0]), Path.of(args[1]));
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
