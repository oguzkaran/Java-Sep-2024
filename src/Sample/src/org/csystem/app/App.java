package org.csystem.app;

class App {
    public static void main(String[] args)
    {
        B b1 = new B(/*...*/);
        B b2 = new B(/*...*/);
        A a = new A(b1/*, ...*/);

        a.doSomething1();
        a.doSomething2();
        a.setB(b2);
        a.doSomething1();
        a.doSomething2();
    }
}

class A {
    private B m_b;
    //...

    public A(B b/*,...*/)
    {
        //...
        m_b = b;
    }

    public B getB()
    {
        return m_b;
    }

    public void setB(B b)
    {
        m_b = b;
    }

    public void doSomething1()
    {
        //...
        m_b.doWork();
        //...
    }

    public void doSomething2()
    {
        //...
        m_b.doWork();
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