package org.csystem.util.array.test;

import java.util.Random;

import static org.csystem.util.array.ArrayUtil.add;
import static org.csystem.util.array.ArrayUtil.randomArray;
import static org.csystem.util.array.ArrayUtil.print;

public class ArrayUtilAddTest {
    public static void run()
    {
        Random random = new Random();

        int [] a = randomArray(random, 10, -10, 11);
        int val = random.nextInt(-10, 10);

        System.out.printf("val = %d%n", val);
        print(a);
        add(a, val);
        print(a);
    }

    public static void main(String [] args)
    {
        run();
    }
}
