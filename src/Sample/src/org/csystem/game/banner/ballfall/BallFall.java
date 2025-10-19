package org.csystem.game.banner.ballfall;

public class BallFall {
	private String m_shape;

	private static void writeSpaces(StringBuilder sb, int begin, int end)
	{
        sb.append(" ".repeat(Math.max(0, end - begin)));
	}
	
	private static void writeBall(StringBuilder sb, int ballIndex, int end)
	{
		writeSpaces(sb, 0, ballIndex);
		sb.append('*');
		writeSpaces(sb, ballIndex + 1, end);
	}
	
	private static boolean updateRightFlag(boolean isRight, int ballIndex, int width)
	{
		if (ballIndex == 0)
			return true;
		
		if (ballIndex == width - 1)
			return false;
		
		return isRight;
	}
	
	private static int updateBallIndex(boolean isRight, int ballIndex)
	{
		if (isRight)
			return ballIndex + 1;
		
		return ballIndex - 1;
	}

	public String getShape()
	{
		return m_shape;
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

		m_shape = sb.toString();
	}

    public String toString()
    {
        return m_shape;
    }
}