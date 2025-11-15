package org.csystem.app;

class App {
    public static void main(String[] args)
    {
        System.out.println(Util.doSomething("something")); //somethingreturnfinally
    }
}

class Util {
    public static StringBuilder doSomething(String str)
    {
        StringBuilder sb = new StringBuilder();

        sb.append(str);

        try {
            return sb.append("return");
        }
        finally {
            sb.append("finally");
        }
    }
}