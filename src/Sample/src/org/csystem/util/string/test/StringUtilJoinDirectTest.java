package org.csystem.util.string.test;

import org.csystem.util.string.StringUtil;

public class StringUtilJoinDirectTest {
	public static void run()
	{
		String [] s1 = {"ankara", "istanbul", "izmir", "zonguldak", "kastamonu"};
		String [] s2 = {"ankara"};
		String s1Expected = "ankaraistanbulizmirzonguldakkastamonu";
		String s2Expected = "ankara";

		System.out.println(StringUtil.join(s1).equals(s1Expected));
		System.out.println(StringUtil.join(s2).equals(s2Expected));
	}

	public static void main(String[] args)
	{
		run();
	}
}