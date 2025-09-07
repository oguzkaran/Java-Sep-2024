package org.csystem.util.datetime;

import org.csystem.datetime.DayOfWeek;
import org.csystem.datetime.Month;

import java.util.Random;


/**
 * Utility class for date-time operations
 * Last Update: 7th September 2025
 * @author Java-Sep-2024 Group
 */
public final class DateTimeUtil {
    private DateTimeUtil()
    {
    }

    private static final Month[] MONTHS = Month.values();
    private static final DayOfWeek[] DAY_OF_WEEKS = DayOfWeek.values();

    public static Month randomMonth(Random random)
    {
        return MONTHS[random.nextInt(MONTHS.length)];
    }

    public static DayOfWeek randomDayOfWeek(Random random)
    {
        return DAY_OF_WEEKS[random.nextInt(DAY_OF_WEEKS.length)];
    }
}
