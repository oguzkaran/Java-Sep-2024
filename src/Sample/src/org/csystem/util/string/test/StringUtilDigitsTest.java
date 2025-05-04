package org.csystem.util.string.test;

import org.csystem.util.string.StringUtil;

public class StringUtilDigitsTest {
	public static void run()
	{
		String s = "Bugün hava 23 derece yarın 25 derece olacakmış";
		String expected = "2325";

		System.out.println(StringUtil.digits(s).equals(expected));
	}

	public static void main(String[] args)
	{
		run();
	}
}