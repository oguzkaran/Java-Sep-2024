package org.csystem.math.util;

import org.csystem.math.Complex;
import org.csystem.math.geometry.Point;

import java.util.Random;

/**
 * Utility class for classes in that library
 * Last Update: 4th October 2025
 * @author Java-Sep-2024 Group
 */
public final class MathUtil {
    private MathUtil()
    {
    }

    public static Point createRandomPoint(Random random, double origin, double bound)
    {
        return Point.createCartesian(random.nextDouble(origin, bound), random.nextDouble(origin, bound));
    }

    public static Point[] createRandomPoints(Random random, int count, double origin, double bound)
    {
        Point [] points = new Point[count];

        for (int i = 0; i < count; ++i)
            points[i] = createRandomPoint(random, origin, bound);

        return points;
    }

    public static Complex createRandomComplex(Random random, double origin, double bound)
    {
        return new Complex(random.nextDouble(origin, bound), random.nextDouble(origin, bound));
    }

    public static Complex[] createRandomComplexNumbers(Random random, int count, double origin, double bound)
    {
        Complex [] numbers = new Complex[count];

        for (int i = 0; i < count; ++i)
            numbers[i] = createRandomComplex(random, origin, bound);

        return numbers;
    }
}
