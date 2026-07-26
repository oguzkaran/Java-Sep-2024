package org.csystem.app.io.file.copy;

import org.csystem.function.IPredicate;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class BackupAsBakFile implements IPredicate<Path> {
    public boolean test(Path path) throws Exception
    {
        Files.copy(path, Path.of("%s-bak".formatted(path.toString())),  StandardCopyOption.REPLACE_EXISTING);

        return true;
    }
}
