package org.csystem.datetime.util.test;

import org.csystem.datetime.util.DateUtil;

class DateAppEN {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);

		System.out.print("Input day month and year values:");
		int day = kb.nextInt();
		int month = kb.nextInt();
		int year = kb.nextInt();

		DateUtil.printDateEN(day, month, year);
	}

	public static void main(String[] args)
	{
		run();
	}
}