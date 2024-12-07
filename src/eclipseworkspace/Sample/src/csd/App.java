package csd;

class App {
	public static void main(String[] args)
	{		
		NumberUtilBextClosestPrimeTest.run();	
	}
}

class NumberUtilBextClosestPrimeTest {
	public static void run()
	{		
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		while (true) {
			System.out.print("Bir sayı giriniz:");
			int a = Integer.parseInt(kb.nextLine());
			
			System.out.printf("%d sayısından büyük ilk asal sayı:%d%n", a, NumberUtil.nextClosestPrime(a));
			
			if (a == 0)
				return;
		}
	}
}

class NumberUtil {
	public static long nextClosestPrime(int a)
	{
		//TODO
	}
	
	public static boolean isPrime(long a)
	{
		if (a <= 1)
			return false;
		
		if (a % 2 == 0)
			return a == 2;
		
		if (a % 3 == 0)
			return a == 3;
		
		if (a % 5 == 0)
			return a == 5;
		
		if (a % 7 == 0)
			return a == 7;
	
		for (long i = 11; i * i <= a; i += 2) 
			if (a % i == 0)
				return false;
		
		return true;
	}
	
	public static boolean isPrimeSlow(long a)
	{
		if (a <= 1)
			return false;
		
		for (long i = 2; i <= a / 2; ++i)
			if (a % i == 0)
				return false;

		return true;
	}
}

