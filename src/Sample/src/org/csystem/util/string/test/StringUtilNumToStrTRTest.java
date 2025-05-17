package org.csystem.util.string.test;

import org.csystem.util.string.StringUtil;

public class StringUtilNumToStrTRTest {
	public static void run()
	{
		System.out.println(StringUtil.numToStrTR(123).equals("yüzyirmiüç"));
		System.out.println(StringUtil.numToStrTR(-123).equals("eksiyüzyirmiüç"));
		System.out.println(StringUtil.numToStrTR(103).equals("yüzüç"));
		System.out.println(StringUtil.numToStrTR(-103).equals("eksiyüzüç"));
		System.out.println(StringUtil.numToStrTR(604).equals("altıyüzdört"));
		System.out.println(StringUtil.numToStrTR(-604).equals("eksialtıyüzdört"));
	}

	public static void main(String[] args)
	{
		run();
	}
}