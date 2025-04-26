package org.csystem.util.array;

import java.util.Random;

/**
 * Utility class for array operations
 * Last Update: 26th April 2025
 * @author Java-Sep-2024 Group
 */
public class ArrayUtil {
    public static double average(int [] a)
    {
        return (double) sum(a) / a.length;
    }

    public static void fillRandomArray(int [] a, Random random, int min, int bound)
    {
        for (int i = 0; i < a.length; ++i)
            a[i] = random.nextInt(min, bound);
    }

    public static int [] generateRandomArray(Random random, int count, int min, int bound)
    {
        int [] a = new int[count];

        fillRandomArray(a, random, min, bound);

        return a;
    }

    public static void print(int [] a, String sep, String end)
    {
        for (int i = 0; i < a.length; ++i)
            System.out.printf("%d%s", a[i], sep);

        System.out.print(end);
    }

    public static void print(int [] a)
    {
        print(a, " ", "\n");
    }

    public static long sum(int [] a)
    {
        long total = 0;

        for (int i = 0; i < a.length; ++i)
            total += a[i];

        return total;
    }

    public static void swap(int [] a, int i, int k)
    {
        int temp = a[i];

        a[i] = a[k];
        a[k] = temp;
    }
}
