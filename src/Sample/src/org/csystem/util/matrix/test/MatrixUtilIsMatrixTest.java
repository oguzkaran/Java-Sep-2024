package org.csystem.util.matrix.test;

import org.csystem.util.matrix.MatrixUtil;

public class MatrixUtilIsMatrixTest {
    public static void run()
    {
        int [][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {0, 1, 2}};
        int [][] b = {{1, 2, 5, 6, 6}, {4, 5}, {7, 8, 9}, {0, 1, 2, 6}};

        System.out.println(MatrixUtil.isMatrix(a));
        System.out.println(!MatrixUtil.isMatrix(b));
    }

    public static void main(String [] args)
    {
        run();
    }
}
