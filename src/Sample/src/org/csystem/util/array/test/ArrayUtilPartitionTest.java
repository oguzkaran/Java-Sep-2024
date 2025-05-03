package org.csystem.util.array.test;

import org.csystem.util.array.ArrayUtil;

public class ArrayUtilPartitionTest {
    public static void run()
    {
        int [] a = {3, 9, -5, 6, 7};
        int [] target = {3, -5, 9, 6, 7};
        int pi = 2;

        int result = ArrayUtil.partition(a, 6);
        System.out.println(ArrayUtil.equals(a, target));
        System.out.println(pi == result);
    }

    public static void main(String [] args)
    {
        run();
    }
}
