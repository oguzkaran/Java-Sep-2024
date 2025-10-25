package org.csystem.math.geometry;

/**
 * AnalyticalCircle class that represents a circle in Cartesian plane
 * Last Update: 25th October 2025
 * @author Java-Sep-2024 Group
 */
public class AnalyticalCircle extends Circle {
    private static final double DELTA = 0.000001;

    private final MutablePoint m_center;

    public AnalyticalCircle()
    {
        this(0);
    }

    public AnalyticalCircle(double radius)
    {
        this(radius, 0, 0);
    }

    public AnalyticalCircle(double x, double y)
    {
        this(0, x, y);
    }

    public AnalyticalCircle(double radius, double x, double y)
    {
        super(radius);
        m_center = MutablePoint.createCartesian(x, y);
    }

    public double getX()
    {
        return m_center.getX();
    }

    public void setX(double x)
    {
        m_center.setX(x);
    }

    public double getY()
    {
        return m_center.getY();
    }

    public void setY(double y)
    {
        m_center.setY(y);
    }

    public double centerDistance(AnalyticalCircle other)
    {
        return m_center.euclideanDistance(other.m_center);
    }

    public boolean isTangent(AnalyticalCircle other)
    {
        return Math.abs(getRadius() + other.getRadius() - centerDistance(other)) < DELTA;
    }

    public void offset(double dxy)
    {
        offset(dxy, dxy);
    }

    public void offset(double dx, double dy)
    {
        m_center.offset(dx, dy);
    }

    public boolean equals(Object other)
    {
        return other instanceof AnalyticalCircle ac && super.equals(ac) && m_center.equals(ac.m_center);
    }

    public String toString()
    {
        return "%s, Center:%s".formatted(super.toString(), m_center);
    }
    //...
}
