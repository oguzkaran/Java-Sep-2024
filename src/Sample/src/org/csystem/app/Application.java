package org.csystem.app;

import org.csystem.util.console.Console;

import java.io.File;

import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;

class Application {
    public static void run(String[] args)
    {
        checkLengthEquals(1, args.length, "Wrong number of arguments");

        var file = new File(args[0]);

        Console.writeLine(file.mkdirs() ? "Created" : "Not created");
    }
}
