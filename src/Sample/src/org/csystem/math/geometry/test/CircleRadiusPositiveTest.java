package org.csystem.math.geometry.test;

import org.csystem.math.geometry.Circle;

public class CircleRadiusPositiveTest {
    public static void run()
    {
        Circle c = new Circle(-3.4);

        System.out.printf(c.toString());
        System.out.println(c.getRadius() >= 0);
    }

    public static void main(String[] args)
    {
        run();
    }
}
