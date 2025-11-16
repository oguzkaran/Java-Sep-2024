package org.csystem.app;

import org.csystem.util.console.Console;

import java.util.InputMismatchException;
import java.util.Scanner;

class App {
    public static void main(String[] args)
    {
        try {
            Scanner kb = new Scanner(System.in);

            System.out.print("Input a value:");
            double a = kb.nextDouble();
            double result = MathUtil.log(a);

            System.out.printf("log(%f) = %f%n", a, result);
        }
        catch (MathException e) {
            Console.writeLine("Exception occurred while calculating logarithm:%s", e.getMessage());
        }
        catch (InputMismatchException e) {
            String message = e.getMessage();

            Console.writeLine("InputMismatchException%s", message != null ? " -> Message:%s".formatted(message) : "");
        }

        System.out.println("main ends");
    }
}

class MathUtil {
    public static final double DELTA = 0.000001;

    public static double log(double a) throws MathException
    {
        if (a < 0)
            throw new NanException("Negative value is not allowed for logarithm", a);

        if (Math.abs(a) < DELTA)
            throw new NegativeInfinityException("Zero value is not allowed for logarithm");

        return Math.log(a);
    }
}

class NanException extends MathException {
    private final double m_value;

    public NanException(double value)
    {
        this(null, value);
    }
    public NanException(String message, double value)
    {
        super(message, MathExceptionStatus.NAN);
        m_value = value;
    }

    public double getValue()
    {
        return m_value;
    }

    public String getMessage()
    {
        return "%s, Value:%f".formatted(super.getMessage(), m_value);
    }
}

class NegativeInfinityException extends MathException {
    public NegativeInfinityException()
    {
        this(null);
    }
    public NegativeInfinityException(String message)
    {
        super(message, MathExceptionStatus.NEGATIVE_INFINITY);
    }
}


class MathException extends RuntimeException {
    private final MathExceptionStatus m_mathExceptionStatus;

    public MathException(MathExceptionStatus mathExceptionStatus)
    {
        this(null, mathExceptionStatus);
    }

    public MathException(String message, MathExceptionStatus mathExceptionStatus)
    {
        super(message);
        m_mathExceptionStatus = mathExceptionStatus;
    }

    public MathExceptionStatus getMathExceptionStatus()
    {
        return m_mathExceptionStatus;
    }

    public String getMessage()
    {
        return "Message:%s, Status:%s".formatted(super.getMessage(), m_mathExceptionStatus);
    }
}

enum MathExceptionStatus {
    NAN, NEGATIVE, ZERO, INFINITY, POSITIVE_INFINITY, NEGATIVE_INFINITY, POSITIVE_ZERO, NEGATIVE_ZERO
}