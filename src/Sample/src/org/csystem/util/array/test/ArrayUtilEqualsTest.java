package org.csystem.util.array.test;

import org.csystem.util.array.ArrayUtil;

public class ArrayUtilEqualsTest {
    public static void run()
    {
        int [] a = {1, 2, 3, 4, 5};
        int [] b = {1, 2, 3, 4, 5};
        int [] c = {1, 2, 3, 4, 6};
        int [] d = {1, 2, 3, 4};

        System.out.println(ArrayUtil.equals(a, b));
        System.out.println(ArrayUtil.equals(a, c));
        System.out.println(ArrayUtil.equals(b, c));
        System.out.println(ArrayUtil.equals(a, d));
    }

    public static void main(String [] args)
    {
        run();
    }
}
