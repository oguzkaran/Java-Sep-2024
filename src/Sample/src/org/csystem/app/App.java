package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		DigitsTest.run();
	}
}

class DigitsTest {
	public static void run()
	{
		String s = "Bugün hava 23 derece yarın 25 derece olacakmış";
		String expected = "2325";

		System.out.println(Util.digits(s).equals(expected));
	}
}

class Util {
	public static String digits(String s)
	{
		char [] c = new char[s.length()];
		int idx = 0;

		for (int i = 0; i < c.length; ++i) {
			char ch = s.charAt(i);

			if (Character.isDigit(ch))
				c[idx++] = ch;
		}

		return new String(c, 0, idx);
	}
}

