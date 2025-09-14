package org.csystem.app.generator;

import org.csystem.math.Complex;
import org.csystem.math.geometry.Circle;
import org.csystem.math.geometry.Point;
import org.csystem.random.generator.ObjectArrayGenerator;
import org.csystem.util.console.Console;

import java.util.Random;

public class DemoObjectArrayGeneratorApp {
    public  static void run()
    {
        int count = Console.readInt("Inout count:");

        ObjectArrayGenerator generator = new ObjectArrayGenerator();

        for (Object o : generator.createObjectArray(count)) {
            Console.writeLine("----------------------------------------------------");
            Console.writeLine("Dynamic type: %s", o.getClass().getName());

            switch (o) {
                case Point p -> Console.writeLine("Distance to origin of %s is %f", p.toString(), p.euclideanDistance());
                case Complex c -> Console.writeLine("Norm of %s is %f", c.toString(), c.getNorm());
                case Circle c -> Console.writeLine("Radius:%f, Area:%f", c.getRadius(), c.getArea());
                case String s -> Console.writeLine("Text:%s, Upper:%s", s, s.toUpperCase());
                default -> {Random random = (Random) o; Console.writeLine("Random number:%d", random.nextInt()); }
            }

            Console.writeLine("----------------------------------------------------");
        }
    }

    public static void main(String[] args)
    {
        run();
    }
}
