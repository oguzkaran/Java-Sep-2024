package org.csystem.util.string.test;

import org.csystem.util.array.ArrayUtil;
import org.csystem.util.string.StringUtil;

public class StringUtilSplitTest {
    public static void run()
    {
        String s = "The quick brown [fox] jumps over the lazy dog.";
        String [] str = {"The", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"};
        String [] strWithEmpties = {"The", "quick", "brown", "", "fox", "", "jumps", "over", "the", "lazy", "dog"};

        System.out.println(ArrayUtil.equals(StringUtil.split(s, " ][.", false), strWithEmpties));
        System.out.println(ArrayUtil.equals(StringUtil.split(s, " ][.", true), str));
    }

    public static void main(String [] args)
    {
        run();
    }
}
