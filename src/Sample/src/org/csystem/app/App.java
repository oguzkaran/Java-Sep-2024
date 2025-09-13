package org.csystem.app;

import org.csystem.util.console.Console;
import org.csystem.util.thread.ThreadUtil;

import java.util.Random;

class App {
    public static void main(String[] args)
    {
        DemoApp.run();
    }
}

class DemoApp {
    public static void run()
    {
        AFactory factory = new AFactory();

        A x;


        while (true) {
            Console.writeLine("--------------------------------");
            x = factory.create();

            Console.writeLine("Dynamic typeof x is '%s'", x.getClass().getName());

            Sample.doWork(x);
            Console.writeLine("--------------------------------");
            ThreadUtil.sleep(1000);
        }

        //...
    }
}

class Sample {
    public static void doWork(A x)
    {
        Console.writeLine("a = %d", x.a);
    }
    //...
}


class AFactory {
    private final Random m_random = new Random();

    public A create()
    {
        return switch (m_random.nextInt(7)) {
            case 1 -> new B();
            case 2 -> new C();
            case 3 -> new D();
            case 4 -> new E();
            case 5 -> new F();
            case 6 -> new G();
            default -> new A();
        };
    }
}

class G extends D {
    public int g;

    //...
}

class F extends A {
    public int f;
    //...
}

class E extends C {
    public int e;
    //...
}

class D extends B {
    public int d;
    //...
}


class C extends B {
    public int c;

    //...
}



class B extends A {
    public int b;

    //..
}

class A {
    public int a;

    //...
}