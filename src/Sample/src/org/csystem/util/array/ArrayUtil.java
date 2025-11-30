package org.csystem.util.array;


import java.util.random.RandomGenerator;

/**
 * Utility class for array operations
 * Last Update: 30th November 2025
 * @author Java-Sep-2024 Group
 */
public final class ArrayUtil {
    private ArrayUtil()
    {
    }

    private static void bubbleSortAscending(int [] a)
    {
        for (int i = 0; i < a.length - 1; ++i)
            for (int k = 0; k < a.length - 1 - i; ++k)
                if (a[k + 1] < a[k])
                    swap(a, k, k + 1);
    }

    private static void bubbleSortDescending(int [] a)
    {
        for (int i = 0; i < a.length - 1; ++i)
            for (int k = 0; k < a.length - 1 - i; ++k)
                if (a[k] < a[k + 1])
                    swap(a, k, k + 1);
    }

    private static void selectionSortAscending(int [] a)
    {
        int min, minIndex;

        for (int i = 0; i < a.length - 1; ++i) {
            min = a[i];
            minIndex = i;

            for (int k = i + 1; k < a.length; ++k)
                if (a[k] < min) {
                    min = a[k];
                    minIndex = k;
                }

            a[minIndex] = a[i];
            a[i] = min;
        }
    }

    private static void selectionSortDescending(int [] a)
    {
        int max, maxIndex;

        for (int i = 0; i < a.length - 1; ++i) {
            max = a[i];
            maxIndex = i;

            for (int k = i + 1; k < a.length; ++k)
                if (max < a[k]) {
                    max = a[k];
                    maxIndex = k;
                }

            a[maxIndex] = a[i];
            a[i] = max;
        }
    }

    public static void add(int [] a, int val)
    {
        for (int i = 0; i < a.length; ++i)
            a[i] += val;
    }

    public static void addBy(int [][] a, int value)
    {
        for (int i = 0; i < a.length; ++i)
            for (int j = 0; j < a[i].length; ++j)
                a[i][j] += value;
    }

    public static double average(int [] a)
    {
        return (double) sum(a) / a.length;
    }

    public static void bubbleSort(int [] a)
    {
        bubbleSort(a, false);
    }


    public static void bubbleSort(int [] a, boolean descending)
    {
        if (descending)
            bubbleSortDescending(a);
        else
            bubbleSortAscending(a);
    }

    public static boolean equals(int [] a, int [] b)
    {
        if (a.length != b.length)
            return false;

        for (int i = 0; i < a.length; ++i)
            if (a[i] != b[i])
                return false;

        return true;
    }

    public static boolean equals(int [][] a, int [][] b)
    {
        if (a.length != b.length)
            return false;

        int len = a.length;

        for (int i = 0; i < len; ++i)
            if (!equals(a[i], b[i]))
                return false;

        return true;
    }

    public static boolean equals(String [] a, String [] b)
    {
        if (a.length != b.length)
            return false;

        for (int i = 0; i < a.length; ++i)
            if (!a[i].equals(b[i]))
                return false;

        return true;
    }

    public static boolean equalsIgnoreCase(String [] a, String [] b)
    {
        if (a.length != b.length)
            return false;

        for (int i = 0; i < a.length; ++i)
            if (!a[i].equalsIgnoreCase(b[i]))
                return false;

        return true;
    }

    public static void fillRandomArray(int [][] a, RandomGenerator randomGenerator, int min, int bound)
    {
        for (int i = 0; i < a.length; ++i)
            for (int j = 0; j < a[i].length; ++j)
                a[i][j] = randomGenerator.nextInt(min, bound);
    }

    public static void fillRandomArray(int [] a, RandomGenerator randomGenerator, int min, int bound)
    {
        for (int i = 0; i < a.length; ++i)
            a[i] = randomGenerator.nextInt(min, bound);
    }

    public static int [] randomArray(RandomGenerator randomGenerator, int count, int min, int bound)
    {
        int [] a = new int[count];

        fillRandomArray(a, randomGenerator, min, bound);

        return a;
    }

    public static int [] histogramData(int [] a, int n)
    {
        int [] counts = new int[n + 1];

        for (int val : a)
            ++counts[val];

        return counts;
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

    public static void multiplyBy(int [][] a, int value)
    {
        for (int i = 0; i < a.length; ++i)
            for (int j = 0; j < a[i].length; ++j)
                a[i][j] *= value;
    }

    public static int partition(int [] a, int threshold)
    {
        int pi = 0;

        while (pi != a.length && a[pi] < threshold)
            ++pi;

        if (pi == a.length)
            return pi;

        for (int i = pi + 1; i < a.length; ++i)
            if (a[i] < threshold)
                swap(a, i, pi++);

        return pi;
    }

    public static int partitionByEven(int [] a)
    {
        int pi = 0;

        while (pi != a.length && a[pi] % 2 == 0)
            ++pi;

        if (pi == a.length)
            return pi;

        for (int i = pi + 1; i < a.length; ++i)
            if (a[i] % 2 == 0)
                swap(a, i, pi++);

        return pi;
    }

    public static void print(int [] a, int n, String sep, String end)
    {
        String fmt = "%%0%dd%%s".formatted(n);
        for (int i = 0; i < a.length - 1; ++i)
            System.out.printf(fmt, a[i], sep);

        System.out.printf(fmt, a[a.length - 1], end);
    }

    public static void print(int [] a, String sep, String end)
    {
        print(a, 1, sep, end);
    }

    public static void print(int [] a)
    {
        print(a, " ", "\n");
    }
    public static void print(int [] a, int n)
    {
        print(a, n, " ", "\n");
    }


    public static void print(int [][] a, int n)
    {
        for (int [] array : a)
            print(array, n);
    }

    public static void print(int [][] a)
    {
        print(a, 1);
    }

    public static void reverse(int [] a)
    {
        int first = 0;
        int last = a.length - 1;

        while (first < last)
            swap(a, first++, last--);
    }

    public static void reverse(char [] a)
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

    public static void selectionSort(int [] a)
    {
        selectionSort(a, false);
    }


    public static void selectionSort(int [] a, boolean descending)
    {
        if (descending)
            selectionSortDescending(a);
        else
            selectionSortAscending(a);
    }

    public static void subtract(int [] a, int val)
    {
        add(a, -val);
    }

    public static void subtractBy(int [][] a, int value)
    {
        addBy(a, -value);
    }

    public static long sum(int [] a)
    {
        long total = 0;

        for (int val : a)
            total += val;

        return total;
    }

    public static void swap(int [] a, int i, int k)
    {
        int temp = a[i];

        a[i] = a[k];
        a[k] = temp;
    }

    public static void swap(char [] a, int i, int k)
    {
        char temp = a[i];

        a[i] = a[k];
        a[k] = temp;
    }
}
