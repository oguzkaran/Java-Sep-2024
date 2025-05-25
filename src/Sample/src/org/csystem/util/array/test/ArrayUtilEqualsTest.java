package org.csystem.util.array.test;

import org.csystem.util.array.ArrayUtil;

public class ArrayUtilEqualsTest {
    public static void run()
    {
        int [] a = {1, 2, 3, 4, 5};
        int [] b = {1, 2, 3, 4, 5};
        int [] c = {1, 2, 3, 4, 6};
        int [] d = {1, 2, 3, 4};
        String [] s1 = {"Şeyma", "Oğuz", "Deniz"};
        String [] s2 = {"Şeyma", "Oğuz", "Deniz"};
        String [] s3 = {"şeyma", "oğuz", "deniz"};

        System.out.println(ArrayUtil.equals(a, b));
        System.out.println(ArrayUtil.equals(a, c));
        System.out.println(ArrayUtil.equals(b, c));
        System.out.println(ArrayUtil.equals(a, d));
        System.out.println(ArrayUtil.equals(s1, s2));
        System.out.println(ArrayUtil.equalsIgnoreCase(s1, s3));
        System.out.println(ArrayUtil.equals(s1, s3));
        System.out.println(ArrayUtil.equals(s2, s3));
    }

    public static void main(String [] args)
    {
        run();
    }
}
