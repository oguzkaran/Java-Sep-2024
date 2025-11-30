package org.csystem.util.matrix;

import org.csystem.util.array.ArrayUtil;

import java.util.random.RandomGenerator;

/**
 * Utility class for matrix operations
 * Last Update: 30th November 2025
 * @author Java-Sep-2024 Group
 */
public final class MatrixUtil {
    private MatrixUtil()
    {
    }

    public static int [][] add(int [][] a, int [][] b)
    {
        int row = a.length;
        int col = a[0].length;

        int [][] r = new int[row][col];

        for (int i = 0; i < row; ++i)
            for (int j = 0; j < col; ++j)
                r[i][j] = a[i][j] + b[i][j];

        return r;
    }

    public static void addBy(int [][] a, int value)
    {
        ArrayUtil.addBy(a, value);
    }

    public static boolean equals(int [][] a, int [][] b)
    {
        return isMatrix(a) && isMatrix(b) && ArrayUtil.equals(a, b);
    }

    public static void fillRandomMatrix(int [][] a, RandomGenerator randomGenerator, int min, int bound)
    {
        ArrayUtil.fillRandomArray(a, randomGenerator, min, bound);
    }

    public static boolean isMatrix(int [][] a)
    {
        for (int i = 1; i < a.length; ++i)
            if (a[i].length != a[0].length)
                return false;

        return true;
    }

    public static boolean isSquareMatrix(int [][] a)
    {
        return isMatrix(a) && a[0].length == a.length;
    }

    public static int [][] multiply(int [][] a, int [][] b)
    {
        int m = a.length;
        int n = a[0].length;
        int p = b[0].length;
        int [][] r = new int[m][p];

        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                for (int k = 0; k < p; ++k)
                    r[i][k] += a[i][j] * b[j][k];

        return r;
    }

    public static void multiplyBy(int [][] a, int value)
    {
        ArrayUtil.multiplyBy(a, value);
    }

    public static int [][] randomMatrix(RandomGenerator randomGenerator, int m, int n, int min, int bound)
    {
        int [][] a = new int[m][n];

        fillRandomMatrix(a, randomGenerator, min, bound);

        return a;
    }

    public static int [][] subtract(int [][] a, int [][] b)
    {
        int row = a.length;
        int col = a[0].length;

        int [][] r = new int[row][col];

        for (int i = 0; i < row; ++i)
            for (int j = 0; j < col; ++j)
                r[i][j] = a[i][j] - b[i][j];

        return r;
    }

    public static void subtractBy(int [][] a, int value)
    {
        addBy(a, -value);
    }

    public static long sumDiagonal(int [][] a)
    {
        long total = 0;

        for (int i = 0; i < a.length; ++i)
            total += a[i][i];

        return total;
    }

    public static int [][] transpose(int [][] a)
    {
        int row = a.length;
        int col = a[0].length;
        int [][] t = new int[col][row];

        for (int i = 0; i < row; ++i)
            for (int j = 0; j < col; ++j)
                t[j][i] = a[i][j];

        return t;
    }
}
