package org.csystem.app.game.lottery;

import org.csystem.game.lottery.NumericLottery;
import org.csystem.util.array.ArrayUtil;

import java.util.Random;
import java.util.Scanner;

public class NumericLotteryApp {
    public static void run()
    {
        Random random = new Random();
        Scanner kb = new Scanner(System.in);
        NumericLottery numericLottery = new NumericLottery(random);

        while (true) {
            System.out.print("Input count:");
            int count = Integer.parseInt(kb.nextLine());

            if (count <= 0)
                break;

            ArrayUtil.print(numericLottery.getNumbers(count), 2);
        }
    }

    public static void main(String[] args)
    {
        run();
    }
}
