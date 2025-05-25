package org.csystem.util.numeric.test;

import static org.csystem.util.numeric.NumberUtil.numToStrTR;

public class NumberUtilNumToStrTRTest {
	public static void run()
	{
		System.out.println(numToStrTR(123).equals("yüzyirmiüç"));
		System.out.println(numToStrTR(-123).equals("eksiyüzyirmiüç"));
		System.out.println(numToStrTR(103).equals("yüzüç"));
		System.out.println(numToStrTR(-103).equals("eksiyüzüç"));
		System.out.println(numToStrTR(604).equals("altıyüzdört"));
		System.out.println(numToStrTR(-604).equals("eksialtıyüzdört"));
	}

	public static void main(String[] args)
	{
		run();
	}
}