### Java ile Nesne Yönelimli Programlama Kursu
### Çalışma Soruları Çözümleri
### Eğitmen: Oğuz KARAN
### C ve Sistem Programcıları Derneği

#### Homework-001

>1.sorunun bir çözümü
>
>**Not:** Çözüm, çalışma sorusunun verildiği tarihe kadar işlenmiş konular kullanılarak yazılmıştır

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
>**Not:** Çözüm, çalışma sorusunun verildiği tarihe kadar işlenmiş konular kullanılarak yazılmıştır

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
>**Not:** Çözüm, çalışma sorusunun verildiği tarihe kadar işlenmiş konular kullanılarak yazılmıştır

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
>**Not:** Çözüm, çalışma sorusunun verildiği tarihe kadar işlenmiş konular kullanılarak yazılmıştır

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
>**Not:** Çözüm, çalışma sorusunun verildiği tarihe kadar işlenmiş konular kullanılarak yazılmıştır

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
>**Not:** Çözüm, çalışma sorusunun verildiği tarihe kadar işlenmiş konular kullanılarak yazılmıştır

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
>**Not:** Çözüm, çalışma sorusunun verildiği tarihe kadar işlenmiş konular kullanılarak yazılmıştır

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
>**Not:** Çözüm, çalışma sorusunun verildiği tarihe kadar işlenmiş konular kullanılarak yazılmıştır

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
>**Not:** Çözüm, çalışma sorusunun verildiği tarihe kadar işlenmiş konular kullanılarak yazılmıştır

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
>**Not:** Çözüm, çalışma sorusunun verildiği tarihe kadar işlenmiş konular kullanılarak yazılmıştır
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

#### Homework-003

>1.sorunun bir çözümü
>
>**Not:** Çözüm, çalışma sorusunun verildiği tarihe kadar işlenmiş konular kullanılarak yazılmıştır

```java
package csd;

class App {
	public static void main(String[] args)
	{		
		SatifyConditionsApp.run();
	}
}

class SatifyConditionsApp {
	public static boolean isCondition1Satisfied(int a, int b, int c)
	{
		return 100 * c + 10 * b + a > 100 * a + 10 * b + c;
	}
	
	public static boolean isCondition2Satisfied(int a, int b, int c)
	{
		return NumberUtil.isPrime(100 * a + 10 * b + c);
	}
	
	public static boolean isCondition3Satisfied(int a, int b, int c)
	{
		return NumberUtil.isPrime(100 * c + 10 * b + a);
	}
	
	public static boolean isCondition4Satisfied(int a, int b)
	{
		return NumberUtil.isPrime(10 * a + b);
	}
	
	public static boolean isCondition5Satisfied(int b, int c)
	{
		return NumberUtil.isPrime(10 * b + c);
	}
	
	public static boolean isCondition6Satisfied(int c, int b)
	{
		return NumberUtil.isPrime(10 * c + b);
	}
	
	public static boolean isCondition7Satisfied(int b, int a)
	{
		return NumberUtil.isPrime(10 * b + a);
	}
	
	public static boolean isAllSatisfied(int val)
	{
		int a = val / 100;
		int b = val / 10 % 10;
		int c = val % 10;
		
		return isCondition1Satisfied(a, b, c) && isCondition2Satisfied(a, b, c) && isCondition3Satisfied(a, b, c)
				&& isCondition4Satisfied(a, b) && isCondition5Satisfied(b, c) && isCondition6Satisfied(c, b) 
				&& isCondition7Satisfied(b, a);
	}
	
	public static void run()
	{
		for (int val = 100; val <= 999; ++val)
			if (isAllSatisfied(val))
				System.out.printf("%d ", val);
		
		System.out.println();
	}
}

class NumberUtil {
	
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

>2.sorunun bir çözümü
>
>**Not:** Çözüm, çalışma sorusunun verildiği tarihe kadar işlenmiş konular kullanılarak yazılmıştır

```java
package csd;

class App {
	public static void main(String[] args)
	{		
		NumberUtilIsPrimeXTest.run();
	}
}

class NumberUtilIsPrimeXTest {	
	
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("Bir sayı giriniz:");
		long n = kb.nextLong();
		
		for (long i = 0; i <= n; ++i)
			if (NumberUtil.isPrimeX(i))
				System.out.println(i);
	}
}

class NumberUtil {
	public static boolean isPrimeX(long a)
	{
		long sum = a;
		boolean result;
		
		while ((result = isPrime(sum)) && sum > 9)
			sum = sumDigits(sum);
		
		return result;
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
	
	public static int sumDigits(long a)
	{
		int total = 0;
		
		while (a != 0) {
			total += a % 10;
			a /= 10;
		}
		
		return Math.abs(total);
	}
}


```

>2.sorunun bir çözümü
>
>**Not:** Çözüm, çalışma sorusunun verildiği tarihe kadar işlenmiş konular kullanılarak yazılmıştır

```java
package csd;

class App {
	public static void main(String[] args)
	{		
		NumberUtilIsPrimeXTest.run();
	}
}

class NumberUtilIsPrimeXTest {	
	
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("Bir sayı giriniz:");
		long n = kb.nextLong();
		
		for (long i = 0; i <= n; ++i)
			if (NumberUtil.isPrimeX(i))
				System.out.println(i);
	}
}

class NumberUtil {
	public static boolean isPrimeX(long a)
	{	
		boolean result;
		
		for (long sum = a; (result = isPrime(sum)) && sum > 9; sum = sumDigits(sum))
			;
				
		return result;
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
	
	public static int sumDigits(long a)
	{
		int total = 0;
		
		while (a != 0) {
			total += a % 10;
			a /= 10;
		}
		
		return Math.abs(total);
	}
}
```

>3.sorunun bir çözümü
>
>**Not:** Çözüm, çalışma sorusunun verildiği tarihe kadar işlenmiş konular kullanılarak yazılmıştır

```java
package csd;

class App {
	public static void main(String[] args)
	{		
		NumberUtilCalculateDigitalRootTest.run();
	}
}

class NumberUtilCalculateDigitalRootTest {	
	
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("Bir sayı giriniz:");
		int n = kb.nextInt();
		
		for (int i = 0; i <= n; ++i)
			System.out.printf("%d -> %d%n", i, NumberUtil.calculateDigitalRoot(i));			
	}
}

class NumberUtil {
	public static int calculateDigitalRoot(int a)
	{
		int root = Math.abs(a);
		
		while (root > 9)
			root = sumDigits(root);
		
		return root;
	}
	
	public static int sumDigits(long a)
	{
		int total = 0;
		
		while (a != 0) {
			total += a % 10;
			a /= 10;
		}
		
		return Math.abs(total);
	}
}

```

>4.sorunun bir çözümü
>
>**Not:** Çözüm, çalışma sorusunun verildiği tarihe kadar işlenmiş konular kullanılarak yazılmıştır

```java
package csd;

class App {
	public static void main(String[] args)
	{		
		NumberUtilIsFactorianTest.run();
	}
}

class NumberUtilIsFactorianTest {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("Bir sayı giriniz:");
		int n = kb.nextInt();
		
		for (int i = 0; i <= n; ++i)
			if (NumberUtil.isFactorian(i))
				System.out.printf("%d ", i);
		
		System.out.println();
	}
}

class NumberUtil {
	public static boolean isFactorian(int n)
	{
		return n > 0 && sumFactorialOfDigits(n) == n;
	}
	
	public static int sumFactorialOfDigits(int n)
	{
		int total = 0;
		
		while (n != 0) {
			total += factorial(n % 10);
			n /= 10;
		}
		
		return total;
	}
	
	public static int factorial(int n)
	{
		int result = 1;
		
		for (int i = 2; i <= n; ++i)
			result *= i;
		
		return result;
	}
}
```

>5.sorunun bir çözümü
>
>**Not:** Çözüm, çalışma sorusunun verildiği tarihe kadar işlenmiş konular kullanılarak yazılmıştır

```java
package csd;

class App {
	public static void main(String[] args)
	{		
		NumberUtilIsSuperPrimeTest.run();
	}
}

class NumberUtilIsSuperPrimeTest {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
			
		System.out.print("Bir sayı giriniz:");
		long n = kb.nextLong();
		
		for (long i = 0; i <= n; ++i)
			if (NumberUtil.isSuperPrime(i))
				System.out.printf("%d ", i);
		
		System.out.println();
	}
}

class NumberUtil {
	public static boolean isSuperPrime(long a)
	{
		return isPrime(a) && isPrime(indexOfPrime(a));		
	}
	
	public static int indexOfPrime(long a)
	{
		int i = 1;
		long val = 2;
		
		while (true) {
			if (val == a)
				return i;
			
			if (isPrime(val))
				++i;
			
			++val;
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

>6.sorunun bir çözümü
>
>**Not:** Çözüm, çalışma sorusunun verildiği tarihe kadar işlenmiş konular kullanılarak yazılmıştır

```java
package csd;

class App {
	public static void main(String[] args)
	{		
		FindHardyRamanujanNumbersApp.run();
	}
}

class FindHardyRamanujanNumbersApp {
	public static void run()
	{
		for (int n = 1; n < 100_000; ++n)
			if (NumberUtil.isHardyRamanujan(n))
				System.out.printf("%d ", n);
		
		System.out.println();
	}
}

class NumberUtil {
	public static boolean isHardyRamanujan(int n)
	{
		return n > 0 && countHardyRamanujan(n) == 2;
	}
	
	public static int countHardyRamanujan(int n)
	{
		int count = 0;
		
		EXIT_LOOP:
		for (int x = 1; x * x * x < n; ++x)
			for (int y = x + 1; x * x * x + y * y * y <= n; ++y) {
				if (x * x * x + y * y * y == n) {
					if (++count == 2)
						break EXIT_LOOP;
					
					++x;
				}
			}
		
		return count;
	}
}
```

>7.sorunun bir çözümü
>
>**Not:** Çözüm, çalışma sorusunun verildiği tarihe kadar işlenmiş konular kullanılarak yazılmıştır

```java
package csd;

class App {
	public static void main(String[] args)
	{		
		NumberUtilIsDecimalHarshadTest.run();
	}
}

class NumberUtilIsDecimalHarshadTest {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("Bir sayı giriniz:");
		int n = kb.nextInt();
		
		for (int i = 0; i <= n; ++i)
			if (NumberUtil.isDecimalHarshad(i))
				System.out.println(i);
		
		System.out.println();
	}
}

class NumberUtil {
	public static boolean isDecimalHarshad(int a)
	{
		return a > 0 && a % sumDigits(a) == 0; 
	}
	
	public static int sumDigits(long a)
	{
		int total = 0;
		
		while (a != 0) {
			total += a % 10;
			a /= 10;
		}
		
		return Math.abs(total);
	}
}
```

>8.sorunun bir çözümü
>
>**Not:** Çözüm, çalışma sorusunun verildiği tarihe kadar işlenmiş konular kullanılarak yazılmıştır

```java
package csd;

class App {
	public static void main(String[] args)
	{		
		NumberUtilPrintCollatzTest.run();
	}
}

class NumberUtilPrintCollatzTest {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		while (true) {
			System.out.print("Bir sayı giriniz:");
			int n = kb.nextInt();
			
			if (n == 0)
				break;
			
			System.out.println("-------------------------------");
			NumberUtil.printCollatz(n);
			System.out.println("-------------------------------");
		}
	}
}

class NumberUtil {
	public static void printCollatz(int n)
	{
		if (n <= 0) {
			System.out.println("Geçersiz sayı!...");
			return;
		}
		
		System.out.println(n);
		
		while (n != 1) {
			if (n % 2 == 0)
				n /= 2;
			else 
				n = 3 * n + 1;
			
			System.out.println(n);
		}
	}
}
```

#### Homework-004

>Sorunun bir çözümü
>
>**Not:** Çözüm, çalışma sorusunun verildiği tarihe kadar işlenmiş konular kullanılarak yazılmıştır
>**Açıklama:** Soruda birden fazla `Scanner` nesnesi yaratılmaması için ve sorunun verildiği tarihte `referans parametreli metotlar` ele alınmadığı için çözüm az metot kullanılarak yazılmıştır.

```java
package csd;
 
class App {
	public static void main(String[] args)
	{	
		CalculateTotalMinMaxCountAverageApp.run();								
	}
}

class CalculateTotalMinMaxCountAverageApp {
	public static void printReport(int total, int count, int min, int max)
	{
		System.out.printf("Toplam %d değer girildi%n", count);
		System.out.printf("Max:%d%nMin:%d%nOrtalama:%.6f%n", max, min, (double)total / count);
	}
	
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		int total, count, min, max;
		
		total = count = 0;
		max = 0;
		min = 100;
		
		while (true) {
			int val;
			
			while (true) {
				System.out.print("Bir tamsayı giriniz:");
				val = Integer.parseInt(kb.nextLine());
				
				if (0 <= val && val <= 100)
					break;
				
				System.out.println("Geçersiz değer girdiniz!...Yeni bir değer giriniz:");
			}
			
			++count;
			total += val;
			min = Math.min(min, val);
			max = Math.max(max, val);
			
			System.out.println("Yeni bir değer girmek istiyor musunuz? [Evet için 1(bir) Hayır için 0(sıfır) değerlerinden birini giriniz]");
			
			int option;
			
			do 
				option = Integer.parseInt(kb.nextLine());			
			while (option != 0 && option != 1);
			
			if (option == 0)
				break;
		}
		
		printReport(total, count, min, max);
	}
}
```
