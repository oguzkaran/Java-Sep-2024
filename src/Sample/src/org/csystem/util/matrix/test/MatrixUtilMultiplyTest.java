package org.csystem.util.matrix.test;

import org.csystem.util.matrix.MatrixUtil;

public class MatrixUtilMultiplyTest {
    public static void run()
    {
        int [][] a = {{1, 0, 1}, {2, 1, 1}, {0, 1, 1}, {1, 1, 2}};
        int [][] b = {{1, 2, 1}, {2, 3, 1}, {4, 2, 2}};
        int [][] r = {{5, 4, 3}, {8, 9, 5}, {6, 5, 3}, {11, 9, 6}};

        System.out.println(MatrixUtil.equals(MatrixUtil.multiply(a, b), r));
    }

    public static void main(String [] args)
    {
        run();
    }
}
