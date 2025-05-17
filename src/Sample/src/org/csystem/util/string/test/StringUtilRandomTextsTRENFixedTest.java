package org.csystem.util.string.test;

import org.csystem.util.string.StringUtil;

import java.util.Random;
import java.util.Scanner;

public class StringUtilRandomTextsTRENFixedTest {
    public static void run()
    {
        Scanner kb = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Input count:");
        int count = kb.nextInt();

        System.out.print("Input n:");
        int n = kb.nextInt();

        String [] textsTR = StringUtil.randomTextsTR(random, count, n);
        String [] textsEN = StringUtil.randomTextsEN(random, count, n);

        for (int i = 0; i < textsTR.length; ++i)
            System.out.printf("%s ", textsTR[i]);

        System.out.println();

        for (int i = 0; i < textsEN.length; ++i)
            System.out.printf("%s ", textsEN[i]);
    }

    public static void main(String[] args)
    {
        run();
    }
}