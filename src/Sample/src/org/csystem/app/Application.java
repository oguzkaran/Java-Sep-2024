package org.csystem.app;

import org.csystem.util.console.Console;
import org.csystem.util.converter.BitConvertUtil;

import java.nio.charset.StandardCharsets;

class Application {
    public static void run(String[] args)
    {
        String str = "Hello\0World";
        byte [] bufUtf8 = str.getBytes(StandardCharsets.UTF_8);
        byte [] bufUtf16 = str.getBytes(StandardCharsets.UTF_16);
        byte [] bufUtf16LE = str.getBytes(StandardCharsets.UTF_16LE);
        byte [] bufUtf16BE = str.getBytes(StandardCharsets.UTF_16BE);

        Console.writeLine(BitConvertUtil.getNullterminatedString(bufUtf8, StandardCharsets.UTF_8));
        Console.writeLine(BitConvertUtil.getNullterminatedString(bufUtf16, StandardCharsets.UTF_16));
        Console.writeLine(BitConvertUtil.getNullterminatedString(bufUtf16LE, StandardCharsets.UTF_16LE));
        Console.writeLine(BitConvertUtil.getNullterminatedString(bufUtf16BE, StandardCharsets.UTF_16BE));
    }
}