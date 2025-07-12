package org.csystem.app;

class App {
	public static void main(String[] args)
	{

	}
}

class ChemistryUtil {
	private ChemistryUtil()
	{
	}

	public static final double AVOGADRO_NUMBER = 6.02E22;
	//...
}

class Sample {
	public final int a; //error
}

class Mample {
	public final int x; //error

	public Mample()
	{
		x = 0;
	}

	public Mample(int a)
	{

	}
}
