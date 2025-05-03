package org.csystem.util.array.test;

import org.csystem.util.array.ArrayUtil;

public class ArrayUtilHistogramDataTest {
    public static void run()
    {
        int [] a = {1, 2, 9, 2, 8, 9, 2, 1, 0, 0, 1, 3, 4, 3, 0, 9, 9, 8, 2, 1, 9};
        int [] counts = {3, 4, 4, 2, 1, 0, 0, 0, 2, 5, 0};

        System.out.println(ArrayUtil.equals(ArrayUtil.histogramData(a, 10), counts));
    }

    public static void main(String [] args)
    {
        run();
    }
}
