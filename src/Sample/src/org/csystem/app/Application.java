package org.csystem.app;

import org.csystem.util.console.Console;

import java.io.File;

import static org.csystem.util.console.commanline.CommandLineArgsUtil.checkLengthEquals;

class Application {
    public static void run(String[] args)
    {
        checkLengthEquals(1, args.length, "Wrong number of arguments");

        var file = new File(args[0]);

        if (file.exists()) {
            if (file.isFile())
                Console.writeLine("%s is a file", args[0]);
            else if (file.isDirectory())
                Console.writeLine("%s is a directory", args[0]);
            else
                Console.writeLine("%s is another type", args[0]);
        }
        else
            Console.writeLine("%s not found", args[0]);
    }
}
