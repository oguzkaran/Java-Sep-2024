package org.csystem.util.array.test;

import org.csystem.util.array.ArrayUtil;

public class ArrayUtilBubbleSortAscendingTest {
    public static void run()
    {
        int [] a = {3, 9, -5, 6, 7, -8};
        int [] target = {-8, -5, 3, 6, 7, 9};

        ArrayUtil.bubbleSort(a);
        System.out.println(ArrayUtil.equals(a, target));
    }

    public static void main(String [] args)
    {
        run();
    }
}
