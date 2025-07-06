package org.csystem.util.matrix.test;

import org.csystem.util.matrix.MatrixUtil;

public class MatrixUtilTransposeTest {
    public static void run()
    {
        int [][] a = {{1, 2, 3}, {4, 5, 6}};
        int [][] t = {{1, 4}, {2, 5}, {3, 6}};

        System.out.println(MatrixUtil.equals(MatrixUtil.transpose(a), t));
        System.out.println(MatrixUtil.equals(MatrixUtil.transpose(t), a));
    }

    public static void main(String [] args)
    {
        run();
    }
}
