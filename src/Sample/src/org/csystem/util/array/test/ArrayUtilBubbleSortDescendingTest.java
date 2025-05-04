package org.csystem.util.array.test;

import org.csystem.util.array.ArrayUtil;

public class ArrayUtilBubbleSortDescendingTest {
    public static void run()
    {
        int [] a = {3, 9, -5, 6, 7, -8};
        int [] target = {9, 7, 6, 3, -5, -8};

        ArrayUtil.bubbleSort(a, true);
        System.out.println(ArrayUtil.equals(a, target));
    }

    public static void main(String [] args)
    {
        run();
    }
}
