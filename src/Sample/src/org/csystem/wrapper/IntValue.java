package org.csystem.wrapper;

/**
 * Immutable class that wraps an int value by using cache for values between [-128, 127]
 * Last Update: 25th October 2025
 * @author Java-Sep-2024 Group
 */
public final class IntValue {
    private static final int CACHE_MIN = -128;
    private static final int CACHE_MAX = 127;
    private static final int INDEX_DIFF = -CACHE_MIN;
    private static final IntValue [] CACHE = new IntValue[CACHE_MAX - CACHE_MIN + 1];
    private final int m_value;

    private IntValue(int value)
    {
        m_value = value;
    }

    public static IntValue of(int value)
    {
        if (value < CACHE_MIN || value > CACHE_MAX)
            return new IntValue(value);

        if (CACHE[value + INDEX_DIFF] == null)
            CACHE[value + INDEX_DIFF] = new IntValue(value);

        return CACHE[value + INDEX_DIFF];
    }

    public int getValue()
    {
        return m_value;
    }

    public boolean equals(Object other)
    {
        return other instanceof IntValue iv && iv.m_value == m_value;
    }

    public String toString()
    {
        return String.valueOf(m_value);
    }
}
