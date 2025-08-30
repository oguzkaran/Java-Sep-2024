package org.csystem.app;

import org.csystem.util.console.Console;

class App {
    public static void main(String[] args)
    {
        A x = new A();
        B y = new B();
        C z = new C();

        x.a = 10;
        x.foo();
        y.a = 20;
        y.b = 30;
        y.foo();
        y.bar();
        z.a = 10;
        z.b = 34;
        z.c = 20;
        z.foo();
        z.bar();
        z.tar();
    }
}

class C extends B {
    public int c;

    public void tar()
    {
        Console.writeLine("C.tar");
    }
}

class B extends A {
    public int b;

    public void bar()
    {
        Console.writeLine("B.bar");
    }
}

class A {
    public int a;

    public void foo()
    {
        Console.writeLine("A.foo");
    }
}