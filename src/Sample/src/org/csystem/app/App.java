package org.csystem.app;

class App {
    public static void main(String[] args)
    {
        B b = new B(/*...*/);
        A a = new A(/*...*/);

        a.doSomething1(b);
        a.doSomething2(b);
    }
}

class A {
    public void doSomething1(B b)
    {
        //...
        b.doWork();
        //...
    }

    public void doSomething2(B b)
    {
        //...
        b.doWork();
        //...
    }
}

class B {
    //...
    public void doWork()
    {
        //...
    }
}