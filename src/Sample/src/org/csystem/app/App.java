package org.csystem.app;

import java.util.Scanner;

class App {
	public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);

		System.out.print("Bir sayı giriniz:");
		long a = kb.nextLong();

		System.out.printf("Eleman sayısı:%d%n", (a != 0) ? ((int)Math.log10(Math.abs(a)) + 1) / 1 : 1);
		System.out.printf("2'şerli Eleman sayısı:%d%n", (a != 0) ? ((int)Math.log10(Math.abs(a)) / 2 + 1) : 1);
		System.out.printf("3'erli Eleman sayısı:%d%n", (a != 0) ? ((int)Math.log10(Math.abs(a)) / 3 + 1) : 1);
	}
}
