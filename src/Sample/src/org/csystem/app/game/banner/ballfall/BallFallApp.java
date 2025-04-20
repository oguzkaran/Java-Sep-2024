package org.csystem.app.game.banner.ballfall;

import org.csystem.game.banner.ballfall.BallFall;

class BallFallApp {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);

		BallFall ballFall = new BallFall();

		while (true) {
			System.out.print("Input width and height:");
			int width = kb.nextInt();
			int height = kb.nextInt();
			
			if (width == 0 || height == 0)
				break;
			
			ballFall.play(width, height);

			System.out.println(ballFall.shape);
		}
	}

	public static void main(String[] args)
	{
		run();
	}
}