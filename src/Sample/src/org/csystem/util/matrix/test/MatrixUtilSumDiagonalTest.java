package org.csystem.util.matrix.test;

import org.csystem.util.matrix.MatrixUtil;

public class MatrixUtilSumDiagonalTest {
    public static void run()
    {
        int [][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        System.out.println(MatrixUtil.sumDiagonal(a) == 15L);
    }

    public static void main(String [] args)
    {
        run();
    }
}
