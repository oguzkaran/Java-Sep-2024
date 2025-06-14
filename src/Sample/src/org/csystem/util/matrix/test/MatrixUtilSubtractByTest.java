package org.csystem.util.matrix.test;

import org.csystem.util.matrix.MatrixUtil;

public class MatrixUtilSubtractByTest {
    public static void run()
    {
        int [][] a = {{1, 2, 3}, {4, 5, 6}};
        int value = 2;
        int [][] r = {{-1, -0, 1}, {2, 3, 4}};

        MatrixUtil.subtractBy(a, value);
        System.out.println(MatrixUtil.equals(a, r));
    }

    public static void main(String [] args)
    {
        run();
    }
}
