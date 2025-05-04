package org.csystem.util.string.test;

import org.csystem.util.string.StringUtil;

public class StringUtilChangeCaseTest {
    public static void run()
    {
        String s = "AnKaRa";
        String expected = "aNkArA";

        System.out.println(StringUtil.changeCase(s).equals(expected));
    }

    public static void main(String [] args)
    {
        run();
    }
}
