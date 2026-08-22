package org.csystem.util.io.file;

import org.csystem.util.io.IOUtil;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UncheckedIOException;

/**
 * Utility class for file operations
 * Last Update: 22nd August 2026
 * @author Java-Sep-2024 Group
 */
public final class FileUtil {
    private FileUtil()
    {
        throw new UnsupportedOperationException("Utility class");
    }

    public static void copy(String srcPath, String destPath, int bufferSize)
    {
        try (FileInputStream fis = new FileInputStream(srcPath); FileOutputStream fos = new FileOutputStream(destPath)) {
            copy(fis, fos, bufferSize);
        }
        catch (IOException e) {
            throw new UncheckedIOException(e.getMessage(), e);
        }
    }

    public static void copy(FileInputStream input, FileOutputStream output, int bufferSize)
    {
        IOUtil.copy(input, output, bufferSize);
    }

    public static void copyAndClose(FileInputStream input, FileOutputStream output, int bufferSize)
    {
        IOUtil.copyAndClose(input, output, bufferSize);
    }

    //...
}
