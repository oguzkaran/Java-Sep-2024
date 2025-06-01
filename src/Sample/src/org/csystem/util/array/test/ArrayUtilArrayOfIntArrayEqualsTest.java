package org.csystem.util.array.test;

import org.csystem.util.array.ArrayUtil;

public class ArrayUtilArrayOfIntArrayEqualsTest {
    public static void run()
    {
        int [][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int [][] b = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int [][] c = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {0, 1, 2}};
        int [][] d = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {0, 1, 2}};
        int [][] e = {{1, 2, 5, 6, 6}, {4, 5}, {7, 8, 9}, {0, 1, 2, 6}};
        int [][] f = {{1, 2, 5, 6, 6}, {4, 5}, {7, 8, 9}, {0, 1, 2, 6}};

        System.out.println(ArrayUtil.equals(a, b));
        System.out.println(ArrayUtil.equals(c, d));
        System.out.println(!ArrayUtil.equals(a, c));
        System.out.println(ArrayUtil.equals(e, f));
        System.out.println(!ArrayUtil.equals(a, f));
    }

    public static void main(String [] args)
    {
        run();
    }
}
