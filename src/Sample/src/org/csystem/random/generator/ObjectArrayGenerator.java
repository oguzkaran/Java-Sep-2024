package org.csystem.random.generator;

import org.csystem.math.Complex;
import org.csystem.math.geometry.AnalyticalCircle;
import org.csystem.math.geometry.Circle;
import org.csystem.math.geometry.Point;
import org.csystem.util.string.StringUtil;

import java.util.Random;

public class ObjectArrayGenerator {
    private final Random m_random = new Random();


    private Object createObject()
    {
        return switch (m_random.nextInt(0, 6)) {
            case 0 -> Point.createCartesian(m_random.nextDouble(-100, 100), m_random.nextDouble(-100, 100));
            case 1 -> new Complex(m_random.nextDouble(-10, 10), m_random.nextDouble(-10, 10));
            case 2 -> new Circle(m_random.nextInt(-10, 10));
            case 3 -> new AnalyticalCircle(m_random.nextInt(-10, 10), m_random.nextInt(-100, 100), m_random.nextInt(-100, 100));
            case 4 -> StringUtil.randomTextEN(m_random, m_random.nextInt(5, 16));
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
