package org.csystem.datetime.util.test;

import org.csystem.datetime.util.DateUtil;

class DateAppTR {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);

		System.out.print("Gün, ay ve yıl bilgilerini giriniz:");
		int day = kb.nextInt();
		int month = kb.nextInt();
		int year = kb.nextInt();

		DateUtil.printDateTR(day, month, year);
	}

	public static void main(String[] args)
	{
		run();
	}
}