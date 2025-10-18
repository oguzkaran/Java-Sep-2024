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

        while (true) {
            A a = factory.create();

            Util.doWork(a);
            ThreadUtil.sleep(2000);
        }
    }
}

class Util {
    public static void doWork(A a)
    {
        Console.writeLine("------------------------------------");
        Console.writeLine("Dynamic type:%s", a.getClass().getName());
        a.foo(0);
        Console.writeLine("------------------------------------");
    }
}

class AFactory {
    private final Random m_random = new Random();

    public A create()
    {
        return switch (m_random.nextInt(1, 9)) {
            case 1 -> new B();
            case 2 -> new C();
            case 3 -> new D();
            case 4 -> new E();
            case 5 -> new F();
            case 6 -> new G();
            case 7 -> new H();
            default -> new A();
        };
    }
}

class H extends B {
    public void foo(int a) //override
    {
        Console.writeLine("H.foo");
    }
}

class G extends C {
    public void foo(int a) //override
    {
        Console.writeLine("G.foo");
    }
    //...
}

class F extends C {
    //...
}


class E extends B {
    //...
}

class D extends B {
    public void foo(int a) //override
    {
        Console.writeLine("D.foo");
    }
    //...
}

class C extends A {
    //...
}

class B extends A {
    //...
    public void foo(int a) //override
    {
        Console.writeLine("B.foo");
    }
}

class A {
    //...
    public void foo(int a) //virtual method
    {
        Console.writeLine("A.foo");
    }

    public final void bar(int a) //non-virtual method
    {
        Console.writeLine("A.bar");
    }

    public static void tar(int a) //non-virtual method
    {
        Console.writeLine("A.tar");
    }
}