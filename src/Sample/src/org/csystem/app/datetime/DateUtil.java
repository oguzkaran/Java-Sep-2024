package org.csystem.app.datetime;

public class DateUtil {
	public static int [] daysOfMonths = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	public static String [] daysOfWeekTR = {"Pazar", "Pazartesi", "Salı", "Çarşamba", "Perşembe", "Cuma", "Cumartesi"};
	public static String [] monthsTR = {"", "Ocak", "Şubat", "Mart", "Nisan", "Mayıs", "Haziran", "Temmuz",
			"Ağustos", "Eylül", "Ekim", "Kasım", "Aralık"};
	public static String [] daysOfWeekEN = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
	public static String [] monthsEN = {"", "January", "February", "March", "April", "May", "June", "July",
			"August", "September", "October", "November", "December"};

	public static void printDateTR(int day, int month, int year)
	{
		String dateStr = getLongDateTR(day, month, year);

		if (!dateStr.isEmpty())
			System.out.println(dateStr);
		else
			System.out.println("Geçersiz tarih");
	}

	public static void printDateEN(int day, int month, int year)
	{
		String dateStr = getLongDateEN(day, month, year);

		if (!dateStr.isEmpty())
			System.out.println(dateStr);
		else
			System.out.println("Invalid date");
	}

	public static String getLongDateEN(int day, int month, int year)
	{
		int dayOfWeek = getDayOfWeek(day, month, year);

		return dayOfWeek != -1 ? "%d%s %s %d %s".formatted(day, getDaySuffix(day), monthsEN[month], year, daysOfWeekEN[dayOfWeek]) : "";
	}

	public static String getLongDateTR(int day, int month, int year)
	{
		int dayOfWeek = getDayOfWeek(day, month, year);

		return dayOfWeek != -1 ? "%d %s %d %s%n".formatted(day, monthsTR[month], year, daysOfWeekTR[dayOfWeek]) : "";
	}

	public static int getDayOfWeek(int day, int month, int year)
	{
		int totalDays;

		if (year < 1900 || (totalDays = getDayOfYear(day, month, year)) == -1)
			return -1;

		for (int y = 1900; y < year; ++y)
			totalDays += isLeapYear(y) ? 366 : 365;

		return totalDays % 7;
	}

	public static int getDayOfYear(int day, int month, int year)
	{
		if (!isValidDate(day, month, year))
			return -1;

		return getDayOfYearValue(day, month, year);
	}

	public static int getDayOfYearValue(int day, int month, int year)
	{
		int dayOfYear = day;

		for (int m = month - 1; m >= 1; --m)
			dayOfYear += getDays(m, year);

		return dayOfYear;
	}

	public static boolean isValidDate(int day, int month, int year)
	{
		return 1 <= day && day <= 31 && 1 <= month && month <= 12 && day <= getDays(month, year);
	}

	public static String getDaySuffix(int day)
	{
		return switch (day) {
			case 1, 21, 31 -> "st";
			case 2, 22 -> "nd";
			case 3, 23 -> "rd";
			default -> "th";
		};
	}

	public static int getDays(int month, int year)
	{
		return month == 2 && isLeapYear(year) ? 29 : daysOfMonths[month];
	}

	public static boolean isLeapYear(int year)
	{
		return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
	}
}