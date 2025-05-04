package org.csystem.util.string.test;

import org.csystem.util.string.StringUtil;

import java.util.Random;
import java.util.Scanner;

public class StringUtilRandomTextTRENTest {
    public static void run()
    {
        Scanner kb = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Input count:");
        int count = kb.nextInt();

        System.out.println(StringUtil.randomTextTR(random, count));
        System.out.println(StringUtil.randomTextEN(random, count));
    }

    public static void main(String[] args)
    {
        run();
    }
}