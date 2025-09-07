package org.csystem.math.geometry.test;

import org.csystem.math.geometry.AnalyticalCircle;
import org.csystem.util.console.Console;

public class AnalyticalCircleCenterDistanceTest {
    private static final double DELTA = 0.000001;

    public static void run()
    {
        AnalyticalCircle ac1 = new AnalyticalCircle(3.4, -100, 200);
        AnalyticalCircle ac2 = new AnalyticalCircle(6.7, -103, 196);
        double expected = 5;

        Console.writeLine(Math.abs(ac1.centerDistance(ac2) - expected) < DELTA);
    }

    public static void main(String[] args)
    {
        run();
    }
}
