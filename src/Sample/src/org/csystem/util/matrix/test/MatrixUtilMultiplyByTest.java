package org.csystem.util.matrix.test;

import org.csystem.util.matrix.MatrixUtil;

public class MatrixUtilMultiplyByTest {
    public static void run()
    {
        int [][] a = {{1, 2, 3}, {4, 5, 6}};
        int value = 2;
        int [][] r = {{2, 4, 6}, {8, 10, 12}};

        MatrixUtil.multiplyBy(a, value);
        System.out.println(MatrixUtil.equals(a, r));
    }

    public static void main(String [] args)
    {
        run();
    }
}
