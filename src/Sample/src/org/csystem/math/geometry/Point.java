package org.csystem.math.geometry;

import static java.lang.Math.sqrt;

/**
 * Point class that represents a point in cartesian coordinates
 * Last Update: 12th April 2025
 * @author Java-Sep-2024 Group
 */

public class Point {
	public double x, y;
	
	public Point()
	{		
	}
	
	public Point(double a)
	{
		x = a;
	}
	
	public Point(double a, double b)
	{
		x = a;
		y = b;
	}

	public double euclideanDistance()
	{
		return euclideanDistance(0, 0);
	}

	public double euclideanDistance(Point other)
	{
		return euclideanDistance(other.x, other.y);
	}
	
	public double euclideanDistance(double a, double b)
	{
		return sqrt((x - a) * (x - a) + (y - b) * (y - b));
	}
	
	public void offset(double dxy)
	{
		offset(dxy, dxy);
	}
	
	public void offset(double dx, double dy)
	{
		x += dx;
		y += dy;
	}
	
	public String toString()
	{
		return "(%f, %f)".formatted(x, y);
	}
}