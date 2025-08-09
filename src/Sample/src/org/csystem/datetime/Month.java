package org.csystem.datetime;


/**
 * Enumeration class that represents month
 * Last Update: 9th August 2025
 * @author Java-Sep-2024 Group
 */
public enum Month {
    JANUARY(31), FEBRUARY(28), MARCH(31), APRIL(30), MAY(31), JUNE(30),
    JULY(31), AUGUST(31), SEPTEMBER(30), OCTOBER(31), NOVEMBER(30), DECEMBER(31);
    private final int m_days;

    Month(int days)
    {
        m_days = days;
    }

    static boolean isLeapYear(int year)
    {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    public int getDays(int year)
    {
        return isLeapYear(year) && ordinal() == 1 ? 29 : m_days;
    }
}
