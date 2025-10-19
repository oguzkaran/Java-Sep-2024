package org.csystem.math.geometry;

import static java.lang.Math.sqrt;

/**
 * Friendly PointCommon class that that is used by Point and MutablePoint to prevent code duplication
 * Last Update: 19th October 2025
 * @author Java-Sep-2024 Group
 */
class PointCommon {
    private PointCommon()
    {
    }

    static final double DELTA = 0.000001;

    static double euclideanDistance(double x1, double y1, double x2, double y2)
    {
        return sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }

    static boolean equals(double x1, double y1, double x2, double y2)
    {
        return Math.abs(x1 - x2) < PointCommon.DELTA && Math.abs(y1 - y2) < PointCommon.DELTA;
    }

    static String toString(double x, double y)
    {
        return "(%f, %f)".formatted(x, y);
    }

    static double getXByPolar(double radius, double theta)
    {
        return radius * Math.cos(theta);
    }

    static double getYByPolar(double radius, double theta)
    {
        return radius * Math.sin(theta);
    }
}
