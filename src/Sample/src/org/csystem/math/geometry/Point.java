package org.csystem.math.geometry;

import static java.lang.Math.sqrt;

/**
 * Point class that represents a point in cartesian coordinates
 * Last Update: 12th July 2025
 * @author Java-Sep-2024 Group
 */

public class Point {
	public double m_x, m_y;

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
		return new Point(radius * Math.cos(theta), radius * Math.sin(theta));
	}

	public double getX()
	{
		return m_x;
	}

	public void setX(double x)
	{
		m_x = x;
	}

	public double getY()
	{
		return m_y;
	}

	public void setY(double y)
	{
		m_y = y;
	}

	public double euclideanDistance()
	{
		return euclideanDistance(0, 0);
	}

	public double euclideanDistance(Point other)
	{
		return euclideanDistance(other.m_x, other.m_y);
	}
	
	public double euclideanDistance(double a, double b)
	{
		return sqrt((m_x - a) * (m_x - a) + (m_y - b) * (m_y - b));
	}
	
	public void offset(double dxy)
	{
		offset(dxy, dxy);
	}
	
	public void offset(double dx, double dy)
	{
		m_x += dx;
		m_y += dy;
	}
	
	public String toString()
	{
		return "(%f, %f)".formatted(m_x, m_y);
	}
}