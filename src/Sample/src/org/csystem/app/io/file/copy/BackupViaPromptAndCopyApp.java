package org.csystem.app.io.file.copy;

import org.csystem.io.file.copy.BackupAndCopy;
import org.csystem.util.console.Console;

import java.io.IOException;
import java.nio.file.Path;

public class BackupViaPromptAndCopyApp {
    private static void run(String[] args)
    {
        try {
            BackupViaPrompt backupViaPrompt = new BackupViaPrompt();
            BackupAndCopy backupAndCopy = new BackupAndCopy(Path.of(args[0]), Path.of(args[1]), backupViaPrompt);

            backupAndCopy.copy();
        }
        catch (IOException e) {
            Console.writeErrLine("IO Error occurred:%s", e.getMessage());
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
