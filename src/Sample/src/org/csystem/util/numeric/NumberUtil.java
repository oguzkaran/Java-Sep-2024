package org.csystem.util.numeric;

/**
 * Utility class for numeric operations
 * Last Update: 19th April 2025
 * @author Java-Sep-2024 Group
 */
public class NumberUtil {
    public static long calculateDigitsPowSum(long a)
    {
        long result = 0;
        int n = countDigits(a);

        while (a != 0) {
            result += (long) Math.pow(a % 10, n);
            a /= 10;
        }

        return result;
    }

    public static int countDigits(long a)
    {
        return (a != 0) ? ((int)Math.log10(Math.abs(a)) + 1) : 1;
    }

    public static int digitsSum(int a)
    {
        int total = 0;

        while (a != 0) {
            total += a % 10;
            a /= 10;
        }

        return Math.abs(total);
    }

    public static int factorial(int n)
    {
        int result = 1;

        for (int i = 2; i <= n; ++i)
            result *= i;

        return result;
    }

    public static int fibonacciNumber(int n)
    {
        if (n <= 2)
            return n - 1;

        int prev1 = 1, prev2 = 0, result = 1;

        for (int i = 3; i < n; ++i) {
            prev2 = prev1;
            prev1 = result;
            result = prev1 + prev2;
        }

        return result;
    }

    public static boolean isArmstrong(long a)
    {
        return a >= 0 && calculateDigitsPowSum(a) == a;
    }

    public static boolean isEven(int a)
    {
        return a % 2 == 0;
    }

    public static boolean isOdd(int a)
    {
        return !isEven(a);
    }

    public static boolean isPrime(long a)
    {
        if (a <= 1)
            return false;

        if (a % 2 == 0)
            return a == 2;

        if (a % 3 == 0)
            return a == 3;

        if (a % 5 == 0)
            return a == 5;

        if (a % 7 == 0)
            return a == 7;

        for (long i = 11; i * i <= a; i += 2)
            if (a % i == 0)
                return false;

        return true;
    }
    public static int nextClosestFibonacciNumber(int a)
    {
        if (a < 0)
            return 0;

        int prev1 = 1, prev2 = 0, next;

        while (true) {
            next = prev1 + prev2;
            if (next > a)
                break;

            prev2 = prev1;
            prev1 = next;
        }

        return next;
    }

    public static long nextClosestPrime(int a)
    {
        if (a < 2)
            return 2;

        long i;

        for (i = a + 1; !isPrime(i); ++i)
            ;

        return i;
    }

    public static long nthPrime(int n)
    {
        long val = 2;
        int count = 0;

        for (long i = 2; count < n; ++i)
            if (isPrime(i)) {
                ++count;
                val = i;
            }

        return val;
    }

    public static int reverse(int a)
    {
        int result = 0;

        while (a != 0) {
            result = result * 10 + a % 10;
            a /= 10;
        }

        return result;
    }
}
