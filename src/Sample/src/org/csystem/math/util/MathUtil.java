package org.csystem.math.util;

import org.csystem.math.Complex;
import org.csystem.math.geometry.Point;

import java.util.random.RandomGenerator;

/**
 * Utility class for classes in that library
 * Last Update: 30th November 2025
 * @author Java-Sep-2024 Group
 */
public final class MathUtil {
    private MathUtil()
    {
    }

    public static Point createRandomPoint(RandomGenerator randomGenerator, int origin, int bound)
    {
        return Point.createCartesian(randomGenerator.nextInt(origin, bound), randomGenerator.nextInt(origin, bound));
    }

    public static Point createRandomPoint(RandomGenerator randomGenerator, double origin, double bound)
    {
        return Point.createCartesian(randomGenerator.nextDouble(origin, bound), randomGenerator.nextDouble(origin, bound));
    }

    public static Point[] createRandomPoints(RandomGenerator randomGenerator, int count, int origin, int bound)
    {
        Point [] points = new Point[count];

        for (int i = 0; i < count; ++i)
            points[i] = createRandomPoint(randomGenerator, origin, bound);

        return points;
    }

    public static Point[] createRandomPoints(RandomGenerator randomGenerator, int count, double origin, double bound)
    {
        Point [] points = new Point[count];

        for (int i = 0; i < count; ++i)
            points[i] = createRandomPoint(randomGenerator, origin, bound);

        return points;
    }

    public static Complex createRandomComplex(RandomGenerator randomGenerator, double origin, double bound)
    {
        return new Complex(randomGenerator.nextDouble(origin, bound), randomGenerator.nextDouble(origin, bound));
    }

    public static Complex[] createRandomComplexNumbers(RandomGenerator randomGenerator, int count, double origin, double bound)
    {
        Complex [] numbers = new Complex[count];

        for (int i = 0; i < count; ++i)
            numbers[i] = createRandomComplex(randomGenerator, origin, bound);

        return numbers;
    }
}
