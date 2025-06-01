package org.csystem.util.matrix.test;

import org.csystem.util.array.ArrayUtil;

public class MatrixUtilArrayOfIntArrayEqualsTest {
    public static void run()
    {
        int [][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int [][] b = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int [][] c = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {0, 1, 2}};
        int [][] d = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {0, 1, 2}};

        System.out.println(ArrayUtil.equals(a, b));
        System.out.println(ArrayUtil.equals(c, d));
        System.out.println(!ArrayUtil.equals(a, c));
    }

    public static void main(String [] args)
    {
        run();
    }
}
