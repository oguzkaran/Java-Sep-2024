package csd;

class App {
	public static void main(String[] args)
	{		
		DateUtilGetDayOfWeekTest.run();
	}
}

class DateUtilGetDayOfWeekTest {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.println("Gün, ay ve yıl bilgilerini giriniz:");
		int day = kb.nextInt();
		int month = kb.nextInt();
		int year = kb.nextInt();
		
		DateUtil.printDateTR(day, month, year);
	}
}

class DateUtil {
	public static void printDateTR(int day, int month, int year)
	{
		int dayOfWeek = getDayOfWeek(day, month, year);	
		
		
		switch (dayOfWeek) {
			case 0 -> System.out.printf("%02d/%02d/%04d Pazar%n", day, month, year);
			case 1 -> System.out.printf("%02d/%02d/%04d Pazartesi%n", day, month, year);
			case 2 -> System.out.printf("%02d/%02d/%04d Salı%n", day, month, year);
			case 3 -> System.out.printf("%02d/%02d/%04d Çarşamba%n", day, month, year);			
			case 4 -> System.out.printf("%02d/%02d/%04d Perşembe%n", day, month, year);
			case 5 -> System.out.printf("%02d/%02d/%04d Cuma%n", day, month, year);
			case 6 -> System.out.printf("%02d/%02d/%04d Cumartesi%n", day, month, year);
			default -> System.out.println("Geçersiz tarih");
		}
				
	}
	
	public static int getDayOfWeek(int day, int month, int year)
	{
		int totalDays;
		
		if (year < 1900 || (totalDays = getDayOfYear(day, month, year)) == -1)
			return -1;
		
		for (int y = 1900; y < year; ++y) {
			totalDays += 365;
			if (isLeapYear(y))
				++totalDays;
		}
		
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
		
		switch (month - 1) {
			case 11:
				dayOfYear += 30;
			case 10:
				dayOfYear += 31;
			case 9:
				dayOfYear += 30;
			case 8:
				dayOfYear += 31;
			case 7:
				dayOfYear += 31;
			case 6:
				dayOfYear += 30;
			case 5:
				dayOfYear += 31;
			case 4:
				dayOfYear += 30;
			case 3:
				dayOfYear += 31;
			case 2:
				dayOfYear += 28;
				if (isLeapYear(year))
					++dayOfYear;
			case 1:
				dayOfYear += 31;
		}
		
		return dayOfYear;
	}
	
	public static boolean isValidDate(int day, int month, int year)
	{
		return 1 <= day && day <= 31 && 1 <= month && month <= 12 && day <= getDays(month, year);
	}
	
	public static int getDays(int month, int year)
	{
		
		return switch (month) {
			case 4, 6, 9, 11 -> 30;
			case 2 -> {		
				if (isLeapYear(year))
					yield 29;
				
				yield 28;
			}
			default -> 31;
		};	
		
	}

	public static boolean isLeapYear(int year)
	{
		return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
	}
}