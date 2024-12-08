package csd;

class App {
	public static void main(String[] args)
	{		
		DemoMenuApp.run();
	}
}

class DemoMenuApp {
	public static void printMenu()
	{
		System.out.println("1.Add");
		System.out.println("2.Update");
		System.out.println("3.Delete");
		System.out.println("4.Search");
		System.out.println("5.Exit");
		System.out.print("Option:");
	}
	
	public static void add()
	{
		System.out.println("-----------------------------------");
		System.out.println("Add selected");
		System.out.println("-----------------------------------");
	}
	
	public static void update()
	{
		System.out.println("-----------------------------------");
		System.out.println("Update selected");
		System.out.println("-----------------------------------");
	}
	
	public static void delete()
	{
		System.out.println("-----------------------------------");
		System.out.println("Delete selected");
		System.out.println("-----------------------------------");
	}
	
	public static void search()
	{
		System.out.println("-----------------------------------");
		System.out.println("Search selected");
		System.out.println("-----------------------------------");
	}
	
	public static void exit()
	{
		System.out.println("-----------------------------------");
		System.out.println("Thanks");
		System.out.println("C and System Programmers Association");
		System.out.println("-----------------------------------");
		System.exit(0);
	}
	
	public static void invalidOption()
	{
		System.out.println("-----------------------------------");
		System.out.println("Invalid option");
		System.out.println("-----------------------------------");
	}
	
	public static void doByOption(int option)
	{
		if (option == 1)
			add();
		else if (option == 2)
			update();
		else if (option == 3)
			delete();
		else if (option == 4)
			search();
		else if (option == 5)
			exit();
		else
			invalidOption();
	}
	
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		while (true) {
			printMenu();			
			doByOption(Integer.parseInt(kb.nextLine()));
		}	
	}
}
