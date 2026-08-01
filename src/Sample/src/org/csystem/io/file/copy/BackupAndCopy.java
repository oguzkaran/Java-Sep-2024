package org.csystem.io.file.copy;

import org.csystem.function.IPredicate;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class BackupAndCopy {
    private final Path m_srcPath;
    private final Path m_destPath;
    private final IPredicate<? super Path> m_predicate;

    private void doIfDestinationPathExists() throws IOException
    {
        try {
            if (m_predicate.test(m_destPath))
                Files.copy(m_srcPath, m_destPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            throw new IOException(e.getMessage());
        }
    }

    public BackupAndCopy(Path srcPath, Path destPath, IPredicate<? super Path> predicate)
    {
        m_srcPath = srcPath;
        m_destPath = destPath;
        m_predicate = predicate;
    }

    public void copy() throws IOException
    {
        try {
            Files.copy(m_srcPath, m_destPath);
        }
        catch (FileAlreadyExistsException ignore) {
            doIfDestinationPathExists();
        }
    }
}
