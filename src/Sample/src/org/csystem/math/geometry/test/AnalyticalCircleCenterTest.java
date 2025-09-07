package org.csystem.math.geometry.test;

import org.csystem.math.geometry.AnalyticalCircle;
import org.csystem.util.console.Console;

public class AnalyticalCircleCenterTest {
    private static final double DELTA = 0.000001;

    public static void run()
    {
        AnalyticalCircle ac = new AnalyticalCircle(3.4, -100.8, 100.9);

        Console.writeLine(Math.abs(ac.getX() - -100.8) < DELTA);
        Console.writeLine(Math.abs(ac.getY() - 100.9) < DELTA);

        ac.offset(-30, 20);

        Console.writeLine(Math.abs(ac.getX() - -130.8) < DELTA);
        Console.writeLine(Math.abs(ac.getY() - 120.9) < DELTA);

    }

    public static void main(String[] args)
    {
        run();
    }
}
