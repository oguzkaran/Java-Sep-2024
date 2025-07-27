package org.csystem.app;

import org.csystem.util.thread.ThreadUtil;

import java.util.Random;

class App {
	public static void main(String[] args)
	{
		PlaneCombatGameApp.run();
	}
}

class PlaneCombatGameApp {
	public static void run()
	{
		Color [] colors = Color.values();
		Direction [] directions = Direction.values();
		//...
		Random random = new Random();
		PlaneGameObject planeGameObject = new PlaneGameObject(colors[random.nextInt(0, 5)]);

		while (true) {
			//...
			System.out.println("---------------------------");
			int direction = random.nextInt(0, 4);

			System.out.printf("Direction value:%d%n", direction);

			planeGameObject.move(directions[direction]);

			//...
			System.out.println("---------------------------");
			ThreadUtil.sleep(1000);
		}

		//...
	}
}

enum Color {
	RED, GREEN, BLUE, BLACK, WHITE
}

enum Direction {
	RIGHT, TOP, LEFT, BOTTOM
}

class PlaneGameObject {
	private final Color m_color;
	//...

	private void displayColor()
	{
		if (m_color == Color.RED)
			System.out.println("Red");
		else if (m_color == Color.GREEN)
			System.out.println("GREEN");
		else if (m_color == Color.BLUE)
			System.out.println("BLUE");
		else if (m_color == Color.BLACK)
			System.out.println("BLACK");
		else if (m_color == Color.WHITE)
			System.out.println("WHITE");
	}

	public PlaneGameObject(Color color)
	{
		System.out.printf("Ordinal value of color:%d%n", color.ordinal());
		m_color = color;
	}

	public void move(Direction direction)
	{
		displayColor();
		//...

		System.out.printf("Ordinal value of direction:%d%n", direction.ordinal());

		if (direction == Direction.RIGHT)
			System.out.println("Right");
		else if (direction == Direction.TOP)
			System.out.println("Top");
		else if (direction == Direction.LEFT)
			System.out.println("Left");
		else if (direction == Direction.BOTTOM)
			System.out.println("Bottom");
	}
	//...
}