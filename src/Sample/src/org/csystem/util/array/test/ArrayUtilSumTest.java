package org.csystem.util.array.test;

import org.csystem.util.array.ArrayUtil;

public class ArrayUtilSumTest {
    public static void run()
    {
        int [] a = {1, 2, 3, 4, 5, 6};

        System.out.println(ArrayUtil.sum(a) == 21);
    }

    public static void main(String [] args)
    {
        run();
    }
}
