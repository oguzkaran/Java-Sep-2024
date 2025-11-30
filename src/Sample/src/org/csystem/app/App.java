package org.csystem.app;

import org.csystem.util.console.Console;
import org.csystem.util.string.StringUtil;

import java.util.Random;
import java.util.random.RandomGenerator;

class App {
    public static void main(String[] args)
    {
        RandomGenerator randomGenerator = RandomGenerator.of("Xoshiro256PlusPlus");
        Random random = new Random();

        for (int i = 0; i < 10; ++i)
            Console.writeLine(StringUtil.randomTextEN(randomGenerator, randomGenerator.nextInt(5, 15)));

        Console.writeLine("-----------------------------------------------------");

        for (int i = 0; i < 10; ++i)
            Console.writeLine(StringUtil.randomTextEN(random, random.nextInt(5, 15)));

    }
}

