package org.csystem.util.numeric;

/**
 * Utility class for numeric operations
 * Last Update: 8th November 2025
 * @author Java-Sep-2024 Group
 */
public final class NumberUtil {
    private static final String [] ONES_TR;
    private static final String [] TENS_TR;

    private static final String [] ONES_EN;
    private static final String [] TENS_EN;

    static {
        ONES_TR = new String[]{"", "bir", "iki", "üç", "dört", "beş", "altı", "yedi", "sekiz", "dokuz"};
        TENS_TR = new String[]{"", "on", "yirmi", "otuz", "kırk", "elli", "altmış", "yetmiş", "seksen", "doksan"};

        ONES_EN = new String[]{"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        TENS_EN = new String[]{"", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    }

    private NumberUtil()
    {
    }

    private static int [] digits(long a, int n)
    {
        a = Math.abs(a);
        int divider = (int)Math.pow(10, n);
        int [] result = new int[(a != 0) ? ((int)Math.log10(Math.abs(a)) / n + 1) : 1];

        for (int i = result.length - 1; i >= 0; result[i--] = (int)(a % divider), a /= divider)
            ;

        return result;
    }

    private static String numToStr3DigitTR(int val)
    {
        if (val == 0)
            return "sıfır";

        StringBuilder sb = new StringBuilder(val < 0 ? "eksi" : "");

        val = Math.abs(val);
        int a = val / 100;
        int b = val / 10 % 10;
        int c = val % 10;

        if (a != 0) {
            if (a != 1)
                sb.append(ONES_TR[a]);

            sb.append("yüz");
        }

        sb.append(TENS_TR[b]);
        sb.append(ONES_TR[c]);

        return sb.toString();
    }

    private static long calculateDigitsPowSum(long a)
    {
        long result = 0;
        int n = countDigits(a);

        while (a != 0) {
            result += (long) Math.pow(a % 10, n);
            a /= 10;
        }

        return result;
    }

    public static int countHardyRamanujan(int n)
    {
        int count = 0;

        EXIT_LOOP:
        for (int x = 1; x * x * x < n; ++x)
            for (int y = x + 1; x * x * x + y * y * y <= n; ++y) {
                if (x * x * x + y * y * y == n) {
                    if (++count == 2)
                        break EXIT_LOOP;

                    ++x;
                }
            }

        return count;
    }

    public static int sumFactorialOfDigits(int n)
    {
        int total = 0;

        while (n != 0) {
            total += factorial(n % 10);
            n /= 10;
        }

        return total;
    }

    public static int countDigits(long a)
    {
        return (a != 0) ? ((int)Math.log10(Math.abs(a)) + 1) : 1;
    }

    public static int [] digits(long a)
    {
        return digits(a, 1);
    }

    public static int [] digitsInTwos(long a)
    {
        return digits(a, 2);
    }

    public static int [] digitsInThrees(long a)
    {
        return digits(a, 3);
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

    public static int indexOfPrime(long a)
    {
        int i = 1;
        long val = 2;

        while (true) {
            if (val == a)
                return i;

            if (isPrime(val))
                ++i;

            ++val;
        }
    }

    public static boolean isArmstrong(long a)
    {
        return a >= 0 && calculateDigitsPowSum(a) == a;
    }

    public static boolean isDecimalHarshad(int a)
    {
        return a > 0 && a % sumDigits(a) == 0;
    }

    public static boolean isEven(int a)
    {
        return a % 2 == 0;
    }

    public static boolean isFactorian(int n)
    {
        return n > 0 && sumFactorialOfDigits(n) == n;
    }

    public static boolean isHardyRamanujan(int n)
    {
        return n > 0 && countHardyRamanujan(n) == 2;
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

    public static boolean isPrimeX(long a)
    {
        long sum = a;
        boolean result;

        while ((result = isPrime(sum)) && sum > 9)
            sum = sumDigits(sum);

        return result;
    }

    public static boolean isSuperPrime(long a)
    {
        return isPrime(a) && isPrime(indexOfPrime(a));
    }

    public static int mid(int a, int b, int c)
    {
        int result = c;

        if (a <= b && b <= c || c <= b && b <= a)
            result = b;
        else if (b <= a && a <= c || c <= a && a <= b)
            result = a;

        return result;
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

    public static String numToStrTR(int val)
    {
        //...

        return numToStr3DigitTR(val);
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

    public static int sumDigits(long a)
    {
        int total = 0;

        while (a != 0) {
            total += a % 10;
            a /= 10;
        }

        return Math.abs(total);
    }
}
