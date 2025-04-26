package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		int [] a = new int[0];

		System.out.printf("Length:%d%n", a.length);

		a = new int[]{};
		System.out.printf("Length:%d%n", a.length);

		a = new int[]{,};
		System.out.printf("Length:%d%n", a.length);

		int [] b = {};
		System.out.printf("Length:%d%n", b.length);

		int [] c = {,};
		System.out.printf("Length:%d%n", c.length);
	}
}

