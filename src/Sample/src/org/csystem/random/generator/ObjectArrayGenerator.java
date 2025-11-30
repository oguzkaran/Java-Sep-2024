package org.csystem.random.generator;

import org.csystem.math.Complex;
import org.csystem.math.geometry.AnalyticalCircle;
import org.csystem.math.geometry.Circle;
import org.csystem.math.geometry.Point;
import org.csystem.util.string.StringUtil;

import java.util.Random;
import java.util.random.RandomGenerator;

public class ObjectArrayGenerator {
    private final RandomGenerator m_randomGenerator = new Random();


    private Object createObject()
    {
        return switch (m_randomGenerator.nextInt(0, 10)) {
            case 0 -> Point.createCartesian(m_randomGenerator.nextDouble(-100, 100), m_randomGenerator.nextDouble(-100, 100));
            case 1 -> new Complex(m_randomGenerator.nextDouble(-10, 10), m_randomGenerator.nextDouble(-10, 10));
            case 2 -> new Circle(m_randomGenerator.nextInt(-10, 10));
            case 3 -> new AnalyticalCircle(m_randomGenerator.nextInt(-10, 10), m_randomGenerator.nextInt(-100, 100), m_randomGenerator.nextInt(-100, 100));
            case 4 -> StringUtil.randomTextEN(m_randomGenerator, m_randomGenerator.nextInt(5, 16));
            case 5 -> m_randomGenerator.nextInt(-128, 128);
            case 6 -> (char)((m_randomGenerator.nextBoolean() ? 'A' : 'a') + m_randomGenerator.nextInt(26));
            case 7 -> m_randomGenerator.nextDouble();
            case 8 -> m_randomGenerator.nextBoolean();
            default -> new Random();
        };
    }

    public Object [] createObjectArray(int count)
    {
        Object [] objects = new Object[count];

        for (int i = 0; i < count; ++i)
            objects[i] = createObject();

        return objects;
    }
}
