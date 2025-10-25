package org.csystem.math.geometry;

/**
 * Circle class that represents a circle
 * Last Update: 25th October 2025
 * @author Java-Sep-2024 Group
 */
public class Circle {
    private static final double DELTA = 0.000001;
    private double m_radius;

    public Circle()
    {
    }

    public Circle(double radius)
    {
        setRadius(radius);
    }

    public double getRadius()
    {
        return m_radius;
    }

    public void setRadius(double radius)
    {
        m_radius = Math.abs(radius);
    }

    public double getArea()
    {
        return Math.PI * m_radius * m_radius;
    }

    public double getCircumference()
    {
        return 2 * Math.PI * m_radius;
    }

    public boolean equals(Object other)
    {
        return other instanceof Circle c && Math.abs(m_radius - c.m_radius) < DELTA;
    }

    public String toString()
    {
        return "Radius:%.2f, Area:%.2f, Circumference:%.2f".formatted(m_radius, getArea(), getCircumference());
    }
}
