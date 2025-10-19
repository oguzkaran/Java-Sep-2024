package org.csystem.math.geometry;

/**
 * Immutable Point class that represents a point in cartesian coordinates
 * Last Update: 19th October 2025
 * @author Java-Sep-2024 Group
 */
public class Point {
	public final double m_x, m_y;

	private Point(double x, double y)
	{
		m_x = x;
		m_y = y;
	}

	public static Point createCartesian()
	{
		return createCartesian(0);
	}

	public static Point createCartesian(double x)
	{
		return createCartesian(x, 0);
	}

	public static Point createCartesian(double x, double y)
	{
		return new Point(x, y);
	}

	public static Point createPolar(double radius, double theta)
	{
		return new Point(PointCommon.getXByPolar(radius, theta), PointCommon.getYByPolar(radius, theta));
	}

	public double getX()
	{
		return m_x;
	}
	public double getY()
	{
		return m_y;
	}

	public double euclideanDistance()
	{
		return euclideanDistance(0, 0);
	}

	public double euclideanDistance(Point other)
	{
		return euclideanDistance(other.m_x, other.m_y);
	}
	
	public double euclideanDistance(double x, double y)
	{
		return PointCommon.euclideanDistance(m_x, m_y, x, y);
	}

    public boolean equals(Object other)
    {
        return other instanceof Point p && PointCommon.equals(m_x, m_y, p.m_x, p.m_y);
    }

	public String toString()
	{
		return PointCommon.toString(m_x, m_y);
	}
}