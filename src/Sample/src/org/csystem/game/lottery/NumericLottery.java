package org.csystem.game.lottery;

import java.util.random.RandomGenerator;

public class NumericLottery {
    private final RandomGenerator m_randomGenerator;

    public static int [] getColumns(boolean [] flags)
    {
        int [] column = new int[6];

        int idx = 0;

        for (int i = 1; i < flags.length; ++i)
            if (flags[i])
                column[idx++] = i;

        return column;
    }

    public boolean [] getFlags()
    {
        boolean [] flags = new boolean[50];

        for (int i = 0; i < 6; ++i) {
            int val;

            while (true) {
                val = m_randomGenerator.nextInt(1, 50);

                if (!flags[val])
                    break;
            }

            flags[val] = true;
        }

        return flags;
    }

    public NumericLottery(RandomGenerator randomGenerator)
    {
        m_randomGenerator = randomGenerator;
    }

    public int [] getNumbers()
    {
        return getColumns(getFlags());
    }

    public int [][] getNumbers(int n)
    {
        int [][] columns = new int[n][];

        for (int i = 0; i < n; ++i)
            columns[i] = getNumbers();

        return columns;
    }
}
