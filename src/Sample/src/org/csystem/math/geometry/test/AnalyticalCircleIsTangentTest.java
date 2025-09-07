package org.csystem.math.geometry.test;

import org.csystem.math.geometry.AnalyticalCircle;
import org.csystem.util.console.Console;

public class AnalyticalCircleIsTangentTest {
    public static void run()
    {
        AnalyticalCircle ac1 = new AnalyticalCircle(3, -100, 200);
        AnalyticalCircle ac2 = new AnalyticalCircle(2, -103, 196);

        Console.writeLine(ac1.isTangent(ac2));
    }

    public static void main(String[] args)
    {
        run();
    }
}
