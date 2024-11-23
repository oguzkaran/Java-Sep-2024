package csd;

class App {
	public static void main(String[] args) 
	{		
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("Bir sayı giriniz:");
		int n = kb.nextInt();
		
		//b = --a; -> i1: 1 -> i2: b = i1
		
		while (n-- > 0) 
			System.out.printf("n = %d%n", n);
		
		System.out.printf("Döngü sonrası -> n = %d%n", n);
		System.out.println("Tekrar yapıyor musunuz?");
	}
}
