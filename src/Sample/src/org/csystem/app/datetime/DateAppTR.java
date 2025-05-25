package org.csystem.app.datetime;

import java.util.Scanner;

class DateAppTR {
	public static void run()
	{
		Scanner kb = new Scanner(System.in);

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