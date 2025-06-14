package org.csystem.util.numeric.test;

import org.csystem.util.array.ArrayUtil;

import static org.csystem.util.numeric.NumberUtil.digitsInTwos;

public class NumberUtilDigitsInTwosTest {
    public static void run()
    {
        long a = 12345678901234L;
        int [] ad = {12, 34, 56, 78, 90, 12, 34};
        long b = -12345678901234L;

        System.out.println(ArrayUtil.equals(digitsInTwos(a), ad));
        System.out.println(ArrayUtil.equals(digitsInTwos(b), ad));

        a = 0;
        ad = new int[1];
        System.out.println(ArrayUtil.equals(digitsInTwos(a), ad));
    }

    public static void main(String[] args)
    {
        run();
    }
}
