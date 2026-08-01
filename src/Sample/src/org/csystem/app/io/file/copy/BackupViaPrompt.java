package org.csystem.app.io.file.copy;

import org.csystem.function.IPredicate;
import org.csystem.util.console.Console;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class BackupViaPrompt implements IPredicate<Path> {
    private static char getOption()
    {
        char c;

        do
            c = Console.readChar("Backup file exists. Do you want to overwrite?");
        while (c != 'Y' && c != 'y' && c != 'N' && c != 'n');

        return c;
    }

    public boolean test(Path path) throws Exception
    {
        char option = getOption();

        if (option == 'Y' || option == 'y')
            Files.copy(path, Path.of("%s-bak".formatted(path.toString())),  StandardCopyOption.REPLACE_EXISTING);

        return true;
    }
}
