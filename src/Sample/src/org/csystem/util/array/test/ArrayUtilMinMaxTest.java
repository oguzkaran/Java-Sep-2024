package org.csystem.util.array.test;

import static org.csystem.util.array.ArrayUtil.max;
import static org.csystem.util.array.ArrayUtil.min;

public class ArrayUtilMinMaxTest {
    public static void run()
    {
        int [] a = {1, -3, 5, 90, -34, 56, 89, 3, -4};

        System.out.println(max(a) == 90);
        System.out.println(min(a) == -34);
    }

    public static void main(String [] args)
    {
        run();
    }
}
