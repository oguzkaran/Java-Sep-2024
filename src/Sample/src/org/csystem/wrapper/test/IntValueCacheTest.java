package org.csystem.wrapper.test;

import org.csystem.wrapper.IntValue;

public class IntValueCacheTest {
    public static void run()
    {
        IntValue i1 = IntValue.of(67);
        IntValue i2 = IntValue.of(67);
        IntValue i3 = IntValue.of(128);
        IntValue i4 = IntValue.of(128);

        System.out.println(i1 == i2);
        System.out.println(i3 != i4);
    }

    public static void main(String[] args)
    {
        run();
    }
}
