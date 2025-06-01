package org.csystem.util.array.test;

import java.util.Random;

import static org.csystem.util.array.ArrayUtil.randomArray;
import static org.csystem.util.array.ArrayUtil.print;
import static org.csystem.util.array.ArrayUtil.reverse;

public class ArrayUtilReverseTest {
    public static void run()
    {
        Random random = new Random();

        int [] a = randomArray(random, random.nextInt(5, 11), 0, 10);

        print(a);
        reverse(a);
        print(a);

    }

    public static void main(String [] args)
    {
        run();
    }
}
