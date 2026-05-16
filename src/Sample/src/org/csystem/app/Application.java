package org.csystem.app;

import org.csystem.util.console.Console;

import java.io.File;

import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;

class Application {
    public static void run(String[] args)
    {
        checkLengthEquals(1, args.length, "Wrong number of arguments");

        var file = new File(args[0]);

        if (file.exists()) {
            if (file.isDirectory()) {
                File [] files = file.listFiles();

                if (files != null) {
                    for (File s : files)
                        Console.writeLine(s.getAbsolutePath());
                }
                else
                    Console.writeLine("IO problem occurred");
            }
            else
                Console.writeLine("'%s' is not a directory", file.getAbsolutePath());
        }
        else
            Console.writeLine("%s not found", args[0]);
    }
}
