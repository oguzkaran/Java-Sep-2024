package org.csystem.app;

import org.csystem.util.console.Console;
import org.csystem.util.converter.BitConvertUtil;

import java.nio.charset.StandardCharsets;

class Application {
    public static void run(String[] args)
    {
        String str = "Hello World";
        int len = 50;

        byte [] dataUtf8 = BitConvertUtil.getNullTerminatedBytes(str, len, StandardCharsets.UTF_8);
        byte [] dataUtf16 = BitConvertUtil.getNullTerminatedBytes(str, len, StandardCharsets.UTF_16);
        byte [] dataUtf16LE = BitConvertUtil.getNullTerminatedBytes(str, len, StandardCharsets.UTF_16LE);
        byte [] dataUtf16BE = BitConvertUtil.getNullTerminatedBytes(str, len, StandardCharsets.UTF_16BE);

        Console.writeLine("(%s)", BitConvertUtil.getNullTerminatedString(dataUtf8, StandardCharsets.UTF_8));
        Console.writeLine("(%s)", BitConvertUtil.getNullTerminatedString(dataUtf16, StandardCharsets.UTF_16));
        Console.writeLine("(%s)", BitConvertUtil.getNullTerminatedString(dataUtf16LE, StandardCharsets.UTF_16LE));
        Console.writeLine("(%s)", BitConvertUtil.getNullTerminatedString(dataUtf16BE, StandardCharsets.UTF_16BE));
    }
}