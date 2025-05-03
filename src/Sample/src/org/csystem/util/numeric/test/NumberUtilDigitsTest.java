package org.csystem.util.numeric.test;

import org.csystem.util.array.ArrayUtil;

import static org.csystem.util.numeric.NumberUtil.digits;

public class NumberUtilDigitsTest {
    public static void run()
    {
        long a = 12345678901234L;
        int [] ad = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4};
        long b = -12345678901234L;

        System.out.println(ArrayUtil.equals(digits(a), ad));
        System.out.println(ArrayUtil.equals(digits(b), ad));

        a = 0;
        ad = new int[1];
        System.out.println(ArrayUtil.equals(digits(a), ad));
    }

    public static void main(String[] args)
    {
        run();
    }
}
