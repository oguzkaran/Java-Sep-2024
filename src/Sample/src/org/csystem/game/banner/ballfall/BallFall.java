package org.csystem.game.banner.ballfall;

public class BallFall {
	public String shape;

	public static void writeSpaces(StringBuilder sb, int begin, int end)
	{
		for (int i = begin; i < end; ++i)
			sb.append(' ');
	}
	
	public static void writeBall(StringBuilder sb, int ballIndex, int end)
	{
		writeSpaces(sb, 0, ballIndex);
		sb.append('*');
		writeSpaces(sb, ballIndex + 1, end);
	}
	
	public static boolean updateRightFlag(boolean isRight, int ballIndex, int width)
	{
		if (ballIndex == 0)
			return true;
		
		if (ballIndex == width - 1)
			return false;
		
		return isRight;
	}
	
	public static int updateBallIndex(boolean isRight, int ballIndex)
	{
		if (isRight)
			return ballIndex + 1;
		
		return ballIndex - 1;
	}
	
	public void play(int width, int height)
	{
		StringBuilder sb = new StringBuilder();
		int ballIndex = 0;
		boolean isRight = false;
		
		for (int i = 1; i <= height; ++i) {
			sb.append('|');
			writeBall(sb, ballIndex, width);
			if (width != 1) {
				isRight = updateRightFlag(isRight, ballIndex, width);
				ballIndex = updateBallIndex(isRight, ballIndex);
			}
			sb.append('|').append("\r\n");
		}

		shape = sb.toString();
	}
}