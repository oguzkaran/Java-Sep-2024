package org.csystem.app.generator;

import org.csystem.math.Complex;
import org.csystem.math.geometry.Circle;
import org.csystem.math.geometry.Point;
import org.csystem.random.generator.ObjectArrayGenerator;
import org.csystem.util.console.Console;

import java.util.Random;
import java.util.random.RandomGenerator;

public class DemoObjectArrayGeneratorApp {
    public  static void run()
    {
        int count = Console.readInt("Input count:");

        ObjectArrayGenerator generator = new ObjectArrayGenerator();

        for (Object o : generator.createObjectArray(count)) {
            Console.writeLine("----------------------------------------------------");
            Console.writeLine("Dynamic type: %s", o.getClass().getName());

            switch (o) {
                case Point p -> Console.writeLine("Distance to origin of %s is %f", p.toString(), p.euclideanDistance());
                case Complex c -> Console.writeLine("Norm of %s is %f", c.toString(), c.getNorm());
                case Circle c -> Console.writeLine("Radius:%f, Area:%f", c.getRadius(), c.getArea());
                case String s -> Console.writeLine("Text:%s, Upper:%s", s, s.toUpperCase());
                case Integer i -> {int a = i; Console.writeLine("%d * %d = %d", a, a, a * a);}
                case Character c -> {char ch = c; Console.writeLine("ch = %c, lower: %c", ch, Character.toLowerCase(ch));}
                case Double d -> {double a = d; Console.writeLine("%f + %f = %f", a, a, a + a);}
                case Boolean b -> {boolean flag = b; Console.writeLine("flag = %b, !flag = %b", flag, !flag);}
                default -> {RandomGenerator orandomGenerator = (Random) o; Console.writeLine("Random number:%d", orandomGenerator.nextInt()); }
            }

            Console.writeLine("----------------------------------------------------");
        }
    }

    public static void main(String[] args)
    {
        run();
    }
}
