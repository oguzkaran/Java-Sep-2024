package org.csystem.app;

class App {
    public static void main(String[] args)
    {

    }
}

class Sample {
    private int m_a;

    public Sample(int a)
    {
        this.m_a = a;
    }

    public int getA(Sample this)
    {
        return m_a;
    }

    public void setA(Sample this, int a)
    {
        m_a = a;
    }
}