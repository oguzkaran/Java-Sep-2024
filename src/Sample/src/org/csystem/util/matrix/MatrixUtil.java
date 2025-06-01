package org.csystem.util.matrix;

import org.csystem.util.array.ArrayUtil;

import java.util.Random;

/**
 * Utility class for matrix operations
 * Last Update: 1st June 2025
 * @author Java-Sep-2024 Group
 */
public class MatrixUtil {
    public static boolean equals(int [][] a, int [][] b)
    {
        return isMatrix(a) && isMatrix(b) && ArrayUtil.equals(a, b);
    }

    public static void fillRandomMatrix(int [][] a, Random random, int min, int bound)
    {
        ArrayUtil.fillRandomArray(a, random, min, bound);
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

    public static int [][] randomMatrix(Random random, int m, int n, int min, int bound)
    {
        int [][] a = new int[m][n];

        fillRandomMatrix(a, random, min, bound);

        return a;
    }
}
