package org.csystem.app;

import org.csystem.util.console.Console;

import java.util.ArrayList;

class App {
    public static void main(String[] args)
    {
        ArrayList<Integer> list = new ArrayList<>();

        while (true) {
            int a = Console.readInt("Input a number:");

            if (a == 0)
                break;

            list.add(a);
        }

        int total = 0;
        for (int a : list)
            total += a;


        Console.writeLine("Total:%d", total);
    }
}


