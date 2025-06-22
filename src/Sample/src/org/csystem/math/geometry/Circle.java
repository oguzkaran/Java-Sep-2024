package org.csystem.math.geometry;

/**
 * Circle class that represents a circle
 * Last Update: 22nd June 2025
 * @author Java-Sep-2024 Group
 */
public class Circle {
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

    public String toString()
    {
        return "Radius:%.2f, Area:%.2f, Circumference:%.2f".formatted(m_radius, getArea(), getCircumference());
    }
}
