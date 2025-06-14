package org.csystem.util.matrix.test;

import org.csystem.util.matrix.MatrixUtil;

public class MatrixUtilSubtractTest {
    public static void run()
    {
        int [][] a = {{1, 2, 3}, {4, 5, 6}};
        int [][] b = {{7, 8, 9}, {5, 8, 9}};
        int [][] r = {{-6, -6, -6}, {-1, -3, -3}};

        System.out.println(MatrixUtil.equals(MatrixUtil.subtract(a, b), r));
    }

    public static void main(String [] args)
    {
        run();
    }
}
