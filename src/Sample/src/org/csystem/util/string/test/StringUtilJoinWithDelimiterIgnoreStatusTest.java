package org.csystem.util.string.test;

import org.csystem.util.string.StringUtil;

public class StringUtilJoinWithDelimiterIgnoreStatusTest {
	public static void run()
	{
		String [] s1 = {"ankara", "istanbul", "   ", "izmir", "", "zonguldak", "", " ", "kastamonu", ""};
		String [] s2 = {"ankara"};
		String s1ExpectedWithAll = "ankara, istanbul,    , izmir, , zonguldak, ,  , kastamonu, ";
		String s1ExpectedIgnoreEmpties = "ankara, istanbul,    , izmir, zonguldak,  , kastamonu";
		String s1ExpectedIgnoreBlanks = "ankara, istanbul, izmir, zonguldak, kastamonu";
		String s2Expected = "ankara";

		System.out.println(StringUtil.join(s1, ", ", 1).equals(s1ExpectedIgnoreEmpties));
		System.out.println(StringUtil.join(s1, ", ", 2).equals(s1ExpectedIgnoreBlanks));
		System.out.println(StringUtil.join(s1, ", ", 0).equals(s1ExpectedWithAll));
		System.out.println(StringUtil.join(s2, ", ", 1).equals(s2Expected));
		System.out.println(StringUtil.join(s2, ", ", 2).equals(s2Expected));
		System.out.println(StringUtil.join(s2, ", ", 0).equals(s2Expected));
	}

	public static void main(String[] args)
	{
		run();
	}
}