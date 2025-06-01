package org.csystem.util.matrix.test;

import org.csystem.util.matrix.MatrixUtil;

public class MatrixUtilIsSquareMatrixTest {
    public static void run()
    {
        int [][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int [][] b = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {0, 1, 2}};
        int [][] c = {{1, 2, 5, 6, 6}, {4, 5}, {7, 8, 9}, {0, 1, 2, 6}};

        System.out.println(MatrixUtil.isSquareMatrix(a));
        System.out.println(!MatrixUtil.isSquareMatrix(b));
        System.out.println(!MatrixUtil.isSquareMatrix(c));
    }

    public static void main(String [] args)
    {
        run();
    }
}
