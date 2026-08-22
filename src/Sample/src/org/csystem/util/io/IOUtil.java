package org.csystem.util.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UncheckedIOException;

/**
 * Utility class for io operations
 * Last Update: 22nd August 2026
 * @author Java-Sep-2024 Group
 */
public final class IOUtil {
    private IOUtil()
    {
        throw new UnsupportedOperationException("Utility class");
    }

    public static void copy(InputStream input, OutputStream output, int bufferSize)
    {
        try {
            byte[] buf = new byte[bufferSize];
            int result;

            while ((result = input.read(buf)) != -1)
                output.write(buf, 0, result);
        }
        catch (IOException e) {
            throw new UncheckedIOException(e.getMessage(), e);
        }
    }

    public static void copyAndClose(InputStream input, OutputStream output, int bufferSize)
    {
        try (input; output) {
            copy(input, output, bufferSize);
        }
        catch (IOException e) {
            throw new UncheckedIOException(e.getMessage(), e);
        }
    }
}
