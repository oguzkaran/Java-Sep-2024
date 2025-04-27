package org.csystem.util.array;

import java.util.Random;

/**
 * Utility class for array operations
 * Last Update: 27th April 2025
 * @author Java-Sep-2024 Group
 */
public class ArrayUtil {
    public static void add(int [] a, int val)
    {
        for (int i = 0; i < a.length; ++i)
            a[i] += val;
    }

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

    public static int max(int [] a)
    {
        int result = a[0];

        for (int i = 1; i < a.length; ++i)
            result = Math.max(result, a[i]);

        return result;
    }

    public static int min(int [] a)
    {
        int result = a[0];

        for (int i = 1; i < a.length; ++i)
            result = Math.min(result, a[i]);

        return result;
    }
    public static void multiply(int [] a, int val)
    {
        for (int i = 0; i < a.length; ++i)
            a[i] *= val;
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

    public static void reverse(int [] a)
    {
        int first = 0;
        int last = a.length - 1;

        while (first < last)
            swap(a, first++, last--);
    }

    public static int [] reversed(int [] a)
    {
        int [] result = new int[a.length];
        int len = a.length;

        for (int i = len - 1; i >= 0; --i)
            result[len - 1 - i] = a[i];

        return result;
    }

    public static void subtract(int [] a, int val)
    {
        add(a, -val);
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
