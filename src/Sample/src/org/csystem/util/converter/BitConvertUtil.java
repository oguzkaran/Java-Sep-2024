package org.csystem.util.converter;

import org.csystem.util.string.StringUtil;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * Utility class for converting primitive types and String to/from byte array
 * @author Oğuz Karan
 */
public final class BitConvertUtil {
    private BitConvertUtil()
    {
        throw new UnsupportedOperationException("Utility class cannot be instantiated.");
    }

    public static byte[] getBytes(int a)
    {
        return ByteBuffer.allocate(Integer.BYTES).putInt(a).array();
    }

    public static byte[] getBytes(long a)
    {
        return ByteBuffer.allocate(Long.BYTES).putLong(a).array();
    }

    public static byte[] getBytes(short a)
    {
        return ByteBuffer.allocate(Short.BYTES).putShort(a).array();
    }

    public static byte[] getBytes(byte a)
    {
        return new byte[] {a};
    }

    public static byte[] getBytes(double a)
    {
        return ByteBuffer.allocate(Double.BYTES).putDouble(a).array();
    }

    public static byte[] getBytes(float a)
    {
        return ByteBuffer.allocate(Float.BYTES).putFloat(a).array();
    }

    public static byte[] getBytes(char a)
    {
        return ByteBuffer.allocate(Character.BYTES).putChar(a).array();
    }

    public static byte [] getBytes(String str)
    {
        return getBytes(str, StandardCharsets.UTF_8);
    }

    public static byte [] getBytes(String str, Charset charset)
    {
        return str.getBytes(charset);
    }

    public static byte [] getNullTerminatedBytes(String str, int fixedLength)
    {
        return getNullTerminatedBytes(str, fixedLength, StandardCharsets.UTF_8);
    }

    public static byte [] getNullTerminatedBytes(String str, int fixedLength, Charset charset)
    {
        return Arrays.copyOf(getBytes(str, charset), fixedLength);
    }

    public static byte [] getNullTerminatedStringBytes(String str, int fixedLength)
    {
        return getNullTerminatedStringBytes(str, fixedLength, StandardCharsets.UTF_8);
    }

    public static byte [] getNullTerminatedStringBytes(String str, int fixedLength, Charset charset)
    {
        return StringUtil.getNullTerminatedString(str, fixedLength).getBytes(charset);
    }

    public static byte[] getBytes(boolean a)
    {
        return new byte[]{(byte)(a ? 1 : 0)};
    }

    public static int toInt(byte [] buf)
    {
        return ByteBuffer.wrap(buf).getInt();
    }

    public static long toLong(byte [] buf)
    {
        return ByteBuffer.wrap(buf).getLong();
    }

    public static short toShort(byte [] buf)
    {
        return ByteBuffer.wrap(buf).getShort();
    }

    public static byte toByte(byte [] buf)
    {
        return buf[0];
    }

    public static double toDouble(byte [] buf)
    {
        return ByteBuffer.wrap(buf).getDouble();
    }

    public static float toFloat(byte [] buf)
    {
        return ByteBuffer.wrap(buf).getFloat();
    }

    public static char toChar(byte [] buf)
    {
        return ByteBuffer.wrap(buf).getChar();
    }

    public static boolean toBoolean(byte [] buf)
    {
        return buf[0] == 1;
    }

    public static String getString(byte [] buf)
    {
        return getString(buf, StandardCharsets.UTF_8);
    }

    public static String getString(byte [] buf, Charset charset)
    {
        return new String(buf, charset);
    }

    public static String getNullTerminatedString(byte [] buf)
    {
        int len = 0;

        while (len < buf.length && buf[len] != 0)
            ++len;

        return new String(buf, 0, len, StandardCharsets.UTF_8);
    }

    public static String getNullTerminatedString(byte [] buf, Charset charset)
    {
        if (charset == StandardCharsets.UTF_8
                || charset == StandardCharsets.US_ASCII
                || charset.name().startsWith("ISO-8859")
                || charset.name().startsWith("windows-")) {
            int len = 0;

            while (len < buf.length && buf[len] != 0)
                ++len;

            return new String(buf, 0, len, charset);
        }

        String str = new String(buf, charset);
        int end = str.indexOf('\0');

        return (end != -1) ? str.substring(0, end) : str;
    }

    public static Charset getCharset(String charsetName, Charset defaultCharset)
    {
        return Charset.isSupported(charsetName) ? Charset.forName(charsetName) : defaultCharset;
    }
}
