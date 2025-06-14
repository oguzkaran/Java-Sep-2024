package org.csystem.util.numeric.test;

import org.csystem.util.array.ArrayUtil;

import static org.csystem.util.numeric.NumberUtil.digitsInThrees;

public class NumberUtilDigitsInThreesTest {
    public static void run()
    {
        long a = 12_345_678_901_234L;
        int [] ad = {12, 345, 678, 901, 234};
        long b = -12_345_678_901_234L;

        System.out.println(ArrayUtil.equals(digitsInThrees(a), ad));
        System.out.println(ArrayUtil.equals(digitsInThrees(b), ad));

        a = 0;
        ad = new int[1];
        System.out.println(ArrayUtil.equals(digitsInThrees(a), ad));
    }

    public static void main(String[] args)
    {
        run();
    }
}
