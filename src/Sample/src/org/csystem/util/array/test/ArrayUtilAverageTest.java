package org.csystem.util.array.test;

import org.csystem.util.array.ArrayUtil;

public class ArrayUtilAverageTest {
    public static void run()
    {
        int [] a = {1, 2, 3, 4, 5, 6};
        double delta = 0.00000001;

        System.out.println(Math.abs(ArrayUtil.average(a) - 3.5) < delta);
    }

    public static void main(String [] args)
    {
        run();
    }
}
