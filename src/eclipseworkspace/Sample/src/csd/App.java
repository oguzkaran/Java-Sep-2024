package csd;

class App {
	public static void main(String[] args) 
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("Bir sayı giriniz:");
		int a = kb.nextInt();
		
		if (a > 6)
			System.out.printf("%d > 6%n", a);
		if (a > 10)
			System.out.printf("%d > 10%n", a);
		if (a > 11)
			System.out.printf("%d > 11%n", a);
		
		System.out.println("Tekrar yapıyor musunuz?");
	}
}
