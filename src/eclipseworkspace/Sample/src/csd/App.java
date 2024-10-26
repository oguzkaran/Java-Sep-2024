package csd;

class App {
	public static void main(String [] args)
	{		
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("İki sayı giriniz:");
		double a = kb.nextDouble();
		double b = kb.nextDouble();		
		
		System.out.printf("%f + %f = %.10f%n", a, b, a + b);		
	}	
}
