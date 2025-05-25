package org.csystem.app.datetime;

import java.util.Scanner;

class DateAppEN {
	public static void run()
	{
		Scanner kb = new Scanner(System.in);

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