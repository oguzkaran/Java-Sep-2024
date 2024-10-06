package csd;

class App {
	public static void main(String [] args)
	{
		System.out.println("Hello, World");
		csd.Sample.foo();
		csd.Sample.bar();
		System.out.println("Goodbye, World");
	}
}

class Sample {
	public static void foo()
	{
		System.out.println("foo");
		csd.Sample.bar();
		//...
	}
	
	public static void bar()
	{
		System.out.println("bar");
		csd.Mample.tar();
		//...
	}
}

class Mample {
	public static void tar()
	{
		System.out.println("tar");
		//...
	}
}

