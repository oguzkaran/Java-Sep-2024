package org.csystem.util.string.test;

import org.csystem.util.string.StringUtil;

public class StringUtilJoinWithDelimiterIgnoreEmptiesTest {
	public static void run()
	{
		String [] s1 = {"ankara", "istanbul", "izmir", "", "zonguldak", "", "kastamonu", ""};
		String [] s2 = {"ankara"};
		String s1ExpectedWithEmpties = "ankara, istanbul, izmir, , zonguldak, , kastamonu, ";
		String s1ExpectedIgnoreEmpties = "ankara, istanbul, izmir, zonguldak, kastamonu";
		String s2Expected = "ankara";

		System.out.println(StringUtil.join(s1, ", ", true).equals(s1ExpectedIgnoreEmpties));
		System.out.println(StringUtil.join(s1, ", ", false).equals(s1ExpectedWithEmpties));
		System.out.println(StringUtil.join(s2, ", ", true).equals(s2Expected));
		System.out.println(StringUtil.join(s2, ", ", false).equals(s2Expected));
	}

	public static void main(String[] args)
	{
		run();
	}
}