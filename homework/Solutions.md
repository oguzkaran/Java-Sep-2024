### Java ile Nesne Yönelimli Programlama Kursu
### Çalışma Soruları Çözümleri
### Eğitmen: Oğuz KARAN
### C ve Sistem Programcıları Derneği

#### Homework-001

>1.sorunun bir çözümü
>
>**Not:** Çözüm, çalışma sorusunun verildiği tarihe işlenmiş konular kullanılarak yazılmıştır

```java
package csd;

class App {
	public static void main(String[] args)
	{		
		PrintRelationsApp.run();
	}
}

class PrintRelationsApp {
	public static void printRelations(int a, int b, int c)
	{
		int max = Math.max(Math.max(a, b), c);
		int min = Math.min(Math.min(a, b), c);
		int mid = a + b + c - max - min;
		
		if (min < mid)
			System.out.printf("%d < %d ", min, mid);
		else
			System.out.printf("%d = %d ", min, mid);
		
		if (mid < max)
			System.out.printf("< %d%n", max);
		else
			System.out.printf("= %d%n", max);
	}
	
	public static void run() 
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("Üç tane sayı giriniz:");
		int a = kb.nextInt();
		int b = kb.nextInt();
		int c = kb.nextInt();
		
		printRelations(a, b, c);
	}
}

```

>2.sorunun bir çözümü
>
>**Not:** Çözüm, çalışma sorusunun verildiği tarihe işlenmiş konular kullanılarak yazılmıştır

```java
package csd;

class App {
	public static void main(String [] args)
	{
		NumberUtilMidTest.run();
	}
}

class NumberUtilMidTest {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("Üç tane sayı giriniz:");
		int a = kb.nextInt();
		int b = kb.nextInt();
		int c = kb.nextInt();
		
		System.out.printf("mid(%d, %d, %d) = %d%n", a, b, c, NumberUtil.mid(a, b, c));
	}
}

class NumberUtil {
	public static int mid(int a, int b, int c)
	{
		if (a <= b && b <= c || c <= b && b <= a)
			return b;
		
		if (b <= a && a <= c || c <= a && a <= b)
			return a;
		
		return c;
	}
}
```
>2.sorunun bir çözümü
>
>**Not:** Çözüm, çalışma sorusunun verildiği tarihe işlenmiş konular kullanılarak yazılmıştır

```java
package csd;

class App {
	public static void main(String [] args)
	{
		NumberUtilMidTest.run();
	}
}

class NumberUtilMidTest {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("Üç tane sayı giriniz:");
		int a = kb.nextInt();
		int b = kb.nextInt();
		int c = kb.nextInt();
		
		System.out.printf("mid(%d, %d, %d) = %d%n", a, b, c, NumberUtil.mid(a, b, c));
	}
}

class NumberUtil {
	public static int mid(int a, int b, int c)
	{
		int result = c;
		
		if (a <= b && b <= c || c <= b && b <= a)
			result = b;		
		else if (b <= a && a <= c || c <= a && a <= b)
			result = a;
		
		return result;
	}
}
```
>3.sorunun bir çözümü
>
>**Not:** Çözüm, çalışma sorusunun verildiği tarihe işlenmiş konular kullanılarak yazılmıştır

```java
package csd;

class App {
	public static void main(String [] args)
	{
		NumberUtilSignumTest.run();
	}
}

class NumberUtilSignumTest {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("Bir sayı giriniz:");
		int a = kb.nextInt();
		
		System.out.printf("signum(%d) = %d%n", a, NumberUtil.signum(a));
	}
}

class NumberUtil {
	public static int signum(int a)
	{
		if (a > 0)
			return 1;
		
		if (a == 0)
			return 0;
		
		return -1;
	}
}

```

>3.sorunun bir çözümü
>
>**Not:** Çözüm, çalışma sorusunun verildiği tarihe işlenmiş konular kullanılarak yazılmıştır

```java
package csd;

class App {
	public static void main(String [] args)
	{
		NumberUtilSignumTest.run();
	}
}

class NumberUtilSignumTest {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("Bir sayı giriniz:");
		int a = kb.nextInt();
		
		System.out.printf("signum(%d) = %d%n", a, NumberUtil.signum(a));
	}
}

class NumberUtil {
	public static int signum(int a)
	{
		int result = -1;
		
		if (a > 0)
			result = 1;		
		else if (a == 0)
			result = 0;
		
		return result;
	}
}

```
#### Homework-002

>1.sorunun bir çözümü
>
>**Not:** Çözüm, çalışma sorusunun verildiği tarihe işlenmiş konular kullanılarak yazılmıştır

```java
package csd;

class App {
	public static void main(String[] args)
	{		
		PrintDiamondApp.run();
	}
}

class PrintDiamondApp {
	public static void printAbove(int n)
	{
		for (int i = 1; i < n; ++i) {
			for (int k = 0; k < n - i; ++k)
				System.out.print(' ');
			
			for (int k = 0; k < 2 * i - 1; ++k)
				System.out.print('*');
			
			System.out.println();
		}
	}
	
	public static void printBelow(int n)
	{
		for (int i = 0; i < n; ++i) {
			for (int k = 0; k < i; ++k)
				System.out.print(' ');
			
			for (int k = 0; k < 2 * (n - i) - 1; ++k)
				System.out.print('*');
			
			System.out.println();
		}
	}
	
	public static void printDiamond(int n)
	{
		printAbove(n);
		printBelow(n);
	}
	
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("Bir sayı giriniz:");
		int n = kb.nextInt();
		
		printDiamond(n);				
	}
}
```
>2.sorunun bir çözümü
>
>**Not:** Çözüm, çalışma sorusunun verildiği tarihe işlenmiş konular kullanılarak yazılmıştır

```java
package csd;

class App {
	public static void main(String[] args)
	{		
		DurationUtilPrintDurationTest.run();
	}
}

class DurationUtilPrintDurationTest {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		while (true) {
			System.out.print("Saniye değerini giriniz:");
			long totalSeconds = Long.parseLong(kb.nextLine());
			
			DurationUtil.printDuration(totalSeconds);
			
			if (totalSeconds == 0)
				break;			
		}
		
						
	}
}

class DurationUtil {
	public static void printDuration(long totalSeconds)
	{
		long hours = totalSeconds / 60 / 60;
		long minutes = totalSeconds / 60 % 60;
		long seconds = totalSeconds % 60;
		
		if (hours != 0)
			System.out.printf("%d saat ", hours);
		
		if (minutes != 0)
			System.out.printf("%d dakika ", minutes);
		
		if (seconds != 0)
			System.out.printf("%d saniye", seconds);
		
		System.out.println();
	}
}
```
>3.sorunun bir çözümü
>
>**Not:** Çözüm, çalışma sorusunun verildiği tarihe işlenmiş konular kullanılarak yazılmıştır

```java
package csd;

class App {
	public static void main(String[] args)
	{		
		PrintPrimeFactorsApp.run();
	}
}

class PrintPrimeFactorsApp {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		while (true) {
			System.out.print("Bir sayı giriniz:");
			int val = Integer.parseInt(kb.nextLine());
			
			if (val <= 0)
				break;
			
			NumberUtil.printPrimeFactors(val);						
		}						
	}
}

class NumberUtil {
	public static void printPrimeFactors(int val)
	{
		int x = 2;
		
		while (val != 1)
			if (val % x == 0) {
				System.out.printf("%d ", x);
				val /= x;
			}
			else
				++x;
		
		System.out.println();
	}
}
```

>4.sorunun bir çözümü
>
>**Not:** Çözüm, çalışma sorusunun verildiği tarihe işlenmiş konular kullanılarak yazılmıştır

```java
package csd;

class App {
	public static void main(String [] args)
	{
		BallFallApp.run();
	}
}

class BallFallApp {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		while (true) {
			System.out.print("Input width and height:");
			int width = kb.nextInt();
			int height = kb.nextInt();
			
			if (width == 0 || height == 0)
				break;
			
			BallFall.play(width, height);
		}
	}
}

class BallFall {
	public static void writeSpaces(int begin, int end)
	{
		for (int i = begin; i < end; ++i)
			System.out.print(' ');
	}
	
	public static void writeBall(int ballIndex, int end)
	{
		writeSpaces(0, ballIndex);
		System.out.print('*');
		writeSpaces(ballIndex + 1, end);
	}
	
	public static boolean updateRightFlag(boolean isRight, int ballIndex, int width)
	{
		if (ballIndex == 0)
			return true;
		
		if (ballIndex == width - 1)
			return false;
		
		return isRight;
	}
	
	public static int updateBallIndex(boolean isRight, int ballIndex)
	{
		if (isRight)
			return ballIndex + 1;
		
		return ballIndex - 1;
	}
	
	public static void play(int width, int height)
	{
		int ballIndex = 0;
		boolean isRight = false;
		
		for (int i = 1; i <= height; ++i) {
			System.out.print('|');
			writeBall(ballIndex, width);
			if (width != 1) {
				isRight = updateRightFlag(isRight, ballIndex, width);
				ballIndex = updateBallIndex(isRight, ballIndex);
			}
			System.out.println('|');
		}
	}
}
```
>5.sorunun bir çözümü
>
>**Not:** Çözüm, çalışma sorusunun verildiği tarihe işlenmiş konular kullanılarak yazılmıştır
```java
package csd;

class App {
	public static void main(String [] args)
	{
		PrintGoldbachApp.run();
	}
}

class PrintGoldbachApp {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		while (true) {
			System.out.print("2'den büyük bir çift sayı giriniz:");
			int val = Integer.parseInt(kb.nextLine());
			
			if (val == 0)
				break;
			
			if (val <= 2 || val % 2 != 0) {
				System.out.println("Geçersiz giriş -> 2'den büyük çift bir sayı girmelisiniz!...");
				continue;
			}
			
			NumberUtil.printGoldbach(val);
		}
	}
}

class NumberUtil {
	public static void printGoldbach(int val)
	{
		for (int x = val - 1; x >= 2; --x) {
			int y = val - x;
			
			if (isPrime(x) && isPrime(y) && x >= y)
				System.out.printf("%d + %d%n", x, y);		
		}
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
}
```
